package com.omouravictor.blooddonationapi.services

import com.omouravictor.blooddonationapi.entities.TipoSanguineo
import com.omouravictor.blooddonationapi.repositories.TipoSanguineoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TipoSanguineoService {

    @Autowired
    lateinit var tipoSanguineoRepository: TipoSanguineoRepository

    fun getTipoSanguineos(): List<TipoSanguineo> = tipoSanguineoRepository.findAll()

    fun getTipoSanguineoById(tipoSanguineoId: Long): TipoSanguineo =
        tipoSanguineoRepository.findById(tipoSanguineoId).orElseThrow()

    fun saveTipoSanguineo(tipoSanguineo: TipoSanguineo): TipoSanguineo = tipoSanguineoRepository.save(tipoSanguineo)

    fun deleteTipoSanguineo(tipoSanguineoId: Long) = tipoSanguineoRepository.deleteById(tipoSanguineoId)

    fun getUpdatedTipoSanguineo(tipoSanguineoId: Long, updatedIipoSanguineo: TipoSanguineo): TipoSanguineo {
        val presentTipoSanguineo = getTipoSanguineoById(tipoSanguineoId)

        presentTipoSanguineo.tipo = updatedIipoSanguineo.tipo ?: presentTipoSanguineo.tipo
        presentTipoSanguineo.fator = updatedIipoSanguineo.fator ?: presentTipoSanguineo.fator

        return presentTipoSanguineo
    }
}
