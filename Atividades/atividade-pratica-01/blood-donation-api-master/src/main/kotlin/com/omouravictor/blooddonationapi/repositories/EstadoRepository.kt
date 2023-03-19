package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.Estado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository : JpaRepository<Estado, Long> {
}
