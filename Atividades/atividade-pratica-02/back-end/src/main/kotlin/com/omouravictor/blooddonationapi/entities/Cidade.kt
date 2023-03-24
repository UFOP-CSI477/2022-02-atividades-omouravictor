package com.omouravictor.blooddonationapi.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "cidades")
data class Cidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String? = null,

    @ManyToOne
    @JoinColumn(name = "estado_id")
    var estado: Estado? = null,

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