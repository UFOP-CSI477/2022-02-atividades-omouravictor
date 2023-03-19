package com.omouravictor.blooddonationapi.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tipos_sanguineos")
data class TipoSanguineo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var tipo: String? = null,
    var fator: String? = null,

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