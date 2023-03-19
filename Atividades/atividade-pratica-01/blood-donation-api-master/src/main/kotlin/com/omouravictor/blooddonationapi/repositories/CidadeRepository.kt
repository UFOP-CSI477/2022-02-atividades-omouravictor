package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository : JpaRepository<Cidade, Long> {
    fun findByEstadoId(estadoId: Long): List<Cidade>
}
