package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.TipoSanguineo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TipoSanguineoRepository : JpaRepository<TipoSanguineo, Long> {
}
