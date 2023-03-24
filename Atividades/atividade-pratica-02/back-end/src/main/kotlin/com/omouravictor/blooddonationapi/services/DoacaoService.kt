package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.Doacao
import com.omouravictor.blooddonationapi.repositories.DoacaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DoacaoService {

    @Autowired
    lateinit var doacaoRepository: DoacaoRepository
    @Autowired
    lateinit var pessoaService: PessoaService
    @Autowired
    lateinit var localColetaService: LocalColetaService

    fun getDoacoes(): List<Doacao> = doacaoRepository.findAll()

    fun getDoacaoById(doacaoId: Long): Doacao = doacaoRepository.findById(doacaoId).orElseThrow()

    fun getDoacoesByPessoaId(pessoaId: Long): List<Doacao> = doacaoRepository.findByPessoaId(pessoaId)

    fun getDoacoesByLocalColetaId(localColetaId: Long): List<Doacao> =
        doacaoRepository.findByLocalColetaId(localColetaId)

    fun saveDoacao(doacao: Doacao): Doacao {
        val savedDoacao = doacaoRepository.save(doacao)

        if (savedDoacao.pessoa?.id != null) {
            savedDoacao.pessoa = pessoaService.getPessoaById(savedDoacao.pessoa!!.id!!)
        }
        if (savedDoacao.localColeta?.id != null) {
            savedDoacao.localColeta = localColetaService.getLocalColetaById(savedDoacao.localColeta!!.id!!)
        }

        return savedDoacao
    }

    fun deleteDoacao(doacaoId: Long) = doacaoRepository.deleteById(doacaoId)

    fun getUpdatedDoacao(doacaoId: Long, updatedDoacao: Doacao): Doacao {
        val presentDoacao = getDoacaoById(doacaoId)

        presentDoacao.pessoa = updatedDoacao.pessoa ?: presentDoacao.pessoa
        presentDoacao.localColeta = updatedDoacao.localColeta ?: presentDoacao.localColeta
        presentDoacao.data = updatedDoacao.data ?: presentDoacao.data

        return presentDoacao
    }
}
