package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.Pessoa
import com.omouravictor.blooddonationapi.repositories.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PessoaService {

    @Autowired
    lateinit var pessoaRepository: PessoaRepository
    @Autowired
    lateinit var cidadeService: CidadeService
    @Autowired
    lateinit var tipoSanguineoService: TipoSanguineoService

    fun getPessoas(): List<Pessoa> = pessoaRepository.findAll()

    fun getPessoaById(pessoaId: Long): Pessoa = pessoaRepository.findById(pessoaId).orElseThrow()

    fun getPessoasByCidadeId(cidadeId: Long): List<Pessoa> = pessoaRepository.findByCidadeId(cidadeId)

    fun getPessoasByTipoSanguineoId(tipoSanguineoId: Long): List<Pessoa> = pessoaRepository.findByTipoSanguineoId(tipoSanguineoId)

    fun savePessoa(pessoa: Pessoa): Pessoa {
        val savedPessoa = pessoaRepository.save(pessoa)

        if (savedPessoa.cidade?.id != null) {
            savedPessoa.cidade = cidadeService.getCidadeById(savedPessoa.cidade!!.id!!)
        }
        if (savedPessoa.tipoSanguineo?.id != null) {
            savedPessoa.tipoSanguineo = tipoSanguineoService.getTipoSanguineoById(savedPessoa.tipoSanguineo!!.id!!)
        }

        return savedPessoa
    }

    fun deletePessoa(pessoaId: Long) = pessoaRepository.deleteById(pessoaId)

    fun getUpdatedPessoa(pessoaId: Long, updatedPessoa: Pessoa): Pessoa {
        val presentPessoa = getPessoaById(pessoaId)

        presentPessoa.nome = updatedPessoa.nome ?: presentPessoa.nome
        presentPessoa.rua = updatedPessoa.rua ?: presentPessoa.rua
        presentPessoa.numero = updatedPessoa.numero ?: presentPessoa.numero
        presentPessoa.complemento = updatedPessoa.complemento ?: presentPessoa.complemento
        presentPessoa.documento = updatedPessoa.documento ?: presentPessoa.documento
        presentPessoa.cidade = updatedPessoa.cidade ?: presentPessoa.cidade
        presentPessoa.tipoSanguineo = updatedPessoa.tipoSanguineo ?: presentPessoa.tipoSanguineo

        return presentPessoa
    }
}
