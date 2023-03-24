package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.Estado
import com.omouravictor.blooddonationapi.services.EstadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/estados")
class EstadoController {

    @Autowired
    lateinit var estadoService: EstadoService

    @GetMapping
    fun getEstados(): ResponseEntity<List<Estado>> = ResponseEntity.ok(estadoService.getEstados())

    @GetMapping("/{estadoId}")
    fun getEstadoById(@PathVariable estadoId: Long): ResponseEntity<Estado> =
        ResponseEntity.ok(estadoService.getEstadoById(estadoId))

    @PostMapping
    fun saveEstado(@RequestBody estado: Estado): ResponseEntity<Estado> =
        ResponseEntity.status(HttpStatus.CREATED).body(estadoService.saveEstado(estado))

    @PutMapping("/{estadoId}")
    fun updateEstado(@PathVariable estadoId: Long, @RequestBody updatedEstado: Estado): ResponseEntity<Estado> {
        val estado = estadoService.getUpdatedEstado(estadoId, updatedEstado)
        return ResponseEntity.ok(estadoService.saveEstado(estado))
    }

    @DeleteMapping("/{estadoId}")
    fun deleteEstado(@PathVariable estadoId: Long): ResponseEntity<String> {
        val estado = estadoService.getEstadoById(estadoId)
        estadoService.deleteEstado(estado.id!!)
        return ResponseEntity.ok("Estado deletado com sucesso! -> $estado")
    }
}
