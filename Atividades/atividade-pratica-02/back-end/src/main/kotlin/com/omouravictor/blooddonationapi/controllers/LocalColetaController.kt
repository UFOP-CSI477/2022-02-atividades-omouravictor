package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.LocalColeta
import com.omouravictor.blooddonationapi.services.LocalColetaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/locais-coleta")
class LocalColetaController {

    @Autowired
    lateinit var localColetaService: LocalColetaService

    @GetMapping
    fun getLocaisColeta(): ResponseEntity<List<LocalColeta>> = ResponseEntity.ok(localColetaService.getLocaisColeta())

    @GetMapping("/{localColetaId}")
    fun getLocalColetaById(@PathVariable localColetaId: Long): ResponseEntity<LocalColeta> =
        ResponseEntity.ok(localColetaService.getLocalColetaById(localColetaId))

    @GetMapping("/cidade/{cidadeId}")
    fun getLocaisColetaByCidadeId(@PathVariable cidadeId: Long): ResponseEntity<List<LocalColeta>> =
        ResponseEntity.ok(localColetaService.getLocaisColetaByCidadeId(cidadeId))

    @PostMapping
    fun saveLocalColeta(@RequestBody localColeta: LocalColeta): ResponseEntity<LocalColeta> =
        ResponseEntity.status(HttpStatus.CREATED).body(localColetaService.saveLocalColeta(localColeta))

    @PutMapping("/{localColetaId}")
    fun updateLocalColeta(@PathVariable localColetaId: Long, @RequestBody updatedLocalColeta: LocalColeta): ResponseEntity<LocalColeta> {
        val localColeta = localColetaService.getUpdatedLocalColeta(localColetaId, updatedLocalColeta)
        return ResponseEntity.ok(localColetaService.saveLocalColeta(localColeta))
    }

    @DeleteMapping("/{localColetaId}")
    fun deleteLocalColeta(@PathVariable localColetaId: Long): ResponseEntity<String> {
        val localColeta = localColetaService.getLocalColetaById(localColetaId)
        localColetaService.deleteLocalColeta(localColeta.id!!)
        return ResponseEntity.ok("Local de Coleta deletado com sucesso! -> $localColeta")
    }
}
