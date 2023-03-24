package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long> {
    fun findByCidadeId(cidadeId: Long): List<Pessoa>
    fun findByTipoSanguineoId(tipoSanguineoId: Long): List<Pessoa>
}
