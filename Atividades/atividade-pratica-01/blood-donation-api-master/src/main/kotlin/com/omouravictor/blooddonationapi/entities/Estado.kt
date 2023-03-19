package com.omouravictor.blooddonationapi.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "estados")
data class Estado(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String? = null,
    var sigla: String? = null,

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