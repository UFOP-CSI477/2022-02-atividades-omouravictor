package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.Estado
import com.omouravictor.blooddonationapi.repositories.EstadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EstadoService {

    @Autowired
    lateinit var estadoRepository: EstadoRepository

    fun getEstados(): List<Estado> = estadoRepository.findAll()

    fun getEstadoById(estadoId: Long): Estado = estadoRepository.findById(estadoId).orElseThrow()

    fun saveEstado(estado: Estado): Estado = estadoRepository.save(estado)

    fun deleteEstado(estadoId: Long) = estadoRepository.deleteById(estadoId)

    fun getUpdatedEstado(estadoId: Long, updatedEstado: Estado): Estado {
        val presentEstado = getEstadoById(estadoId)

        presentEstado.nome = updatedEstado.nome ?: presentEstado.nome
        presentEstado.sigla = updatedEstado.sigla ?: presentEstado.sigla

        return presentEstado
    }
}
