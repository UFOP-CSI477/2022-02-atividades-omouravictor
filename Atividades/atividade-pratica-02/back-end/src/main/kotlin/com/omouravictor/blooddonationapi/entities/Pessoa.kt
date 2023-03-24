package com.omouravictor.blooddonationapi.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "pessoas")
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String? = null,
    var rua: String? = null,
    var numero: String? = null,
    var complemento: String? = null,
    var documento: String? = null,

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    var cidade: Cidade? = null,

    @ManyToOne
    @JoinColumn(name = "tipo_sanguineo_id")
    var tipoSanguineo: TipoSanguineo? = null,

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