package com.omouravictor.blooddonationapi.repositories

import com.omouravictor.blooddonationapi.entities.Doacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoacaoRepository : JpaRepository<Doacao, Long> {
    fun findByPessoaId(pessoaId: Long): List<Doacao>
    fun findByLocalColetaId(localColetaId: Long): List<Doacao>
}
