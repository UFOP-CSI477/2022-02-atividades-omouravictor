package com.omouravictor.blooddonationapi.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "doacoes")
data class Doacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    var pessoa: Pessoa? = null,

    @ManyToOne
    @JoinColumn(name = "local_coleta_id")
    var localColeta: LocalColeta? = null,

    var data: LocalDateTime? = null,

    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
) {

    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
        updatedAt = createdAt
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}