package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.Cidade
import com.omouravictor.blooddonationapi.repositories.CidadeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CidadeService {

    @Autowired
    lateinit var cidadeRepository: CidadeRepository
    @Autowired
    lateinit var estadoService: EstadoService

    fun getCidades(): List<Cidade> = cidadeRepository.findAll()

    fun getCidadeById(cidadeId: Long): Cidade = cidadeRepository.findById(cidadeId).orElseThrow()

    fun getCidadesByEstadoId(estadoId: Long): List<Cidade> = cidadeRepository.findByEstadoId(estadoId)

    fun saveCidade(cidade: Cidade): Cidade {
        val savedCidade = cidadeRepository.save(cidade)

        if (savedCidade.estado?.id != null) {
            savedCidade.estado = estadoService.getEstadoById(savedCidade.estado!!.id!!)
        }

        return savedCidade
    }

    fun deleteCidade(cidadeId: Long) = cidadeRepository.deleteById(cidadeId)

    fun getUpdatedCidade(cidadeId: Long, updatedCidade: Cidade): Cidade {
        val presentCidade = getCidadeById(cidadeId)

        presentCidade.nome = updatedCidade.nome ?: presentCidade.nome
        presentCidade.estado = updatedCidade.estado ?: presentCidade.estado

        return presentCidade
    }
}
