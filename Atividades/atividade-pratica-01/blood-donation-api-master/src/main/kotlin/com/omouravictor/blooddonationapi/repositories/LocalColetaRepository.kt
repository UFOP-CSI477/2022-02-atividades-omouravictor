package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.LocalColeta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocalColetaRepository : JpaRepository<LocalColeta, Long> {
    fun findByCidadeId(cidadeId: Long): List<LocalColeta>
}
