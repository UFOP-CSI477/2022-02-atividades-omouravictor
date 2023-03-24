package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.LocalColeta
import com.omouravictor.blooddonationapi.repositories.LocalColetaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocalColetaService {

    @Autowired
    lateinit var localColetaRepository: LocalColetaRepository
    @Autowired
    lateinit var cidadeService: CidadeService

    fun getLocaisColeta(): List<LocalColeta> = localColetaRepository.findAll()

    fun getLocalColetaById(localColetaId: Long): LocalColeta =
        localColetaRepository.findById(localColetaId).orElseThrow()

    fun getLocaisColetaByCidadeId(cidadeId: Long): List<LocalColeta> = localColetaRepository.findByCidadeId(cidadeId)

    fun saveLocalColeta(localColeta: LocalColeta): LocalColeta {
        val savedLocalColeta = localColetaRepository.save(localColeta)

        if (savedLocalColeta.cidade?.id != null) {
            savedLocalColeta.cidade = cidadeService.getCidadeById(savedLocalColeta.cidade!!.id!!)
        }

        return savedLocalColeta
    }

    fun deleteLocalColeta(localColetaId: Long) = localColetaRepository.deleteById(localColetaId)

    fun getUpdatedLocalColeta(localColetaId: Long, updatedLocalColeta: LocalColeta): LocalColeta {
        val presentLocalColeta = getLocalColetaById(localColetaId)

        presentLocalColeta.nome = updatedLocalColeta.nome ?: presentLocalColeta.nome
        presentLocalColeta.rua = updatedLocalColeta.rua ?: presentLocalColeta.rua
        presentLocalColeta.numero = updatedLocalColeta.numero ?: presentLocalColeta.numero
        presentLocalColeta.complemento = updatedLocalColeta.complemento ?: presentLocalColeta.complemento
        presentLocalColeta.cidade = updatedLocalColeta.cidade ?: presentLocalColeta.cidade

        return presentLocalColeta
    }
}
