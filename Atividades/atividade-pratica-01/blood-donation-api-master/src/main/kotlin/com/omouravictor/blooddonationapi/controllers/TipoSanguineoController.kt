package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.TipoSanguineo
import com.omouravictor.blooddonationapi.services.TipoSanguineoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tipos-sanguineos")
class TipoSanguineoController {

    @Autowired
    lateinit var tipoSanguineoService: TipoSanguineoService

    @GetMapping
    fun getTipoSanguineos(): ResponseEntity<List<TipoSanguineo>> = ResponseEntity.ok(tipoSanguineoService.getTipoSanguineos())

    @GetMapping("/{tipoSanguineoId}")
    fun getTipoSanguineoById(@PathVariable tipoSanguineoId: Long): ResponseEntity<TipoSanguineo> =
        ResponseEntity.ok(tipoSanguineoService.getTipoSanguineoById(tipoSanguineoId))

    @PostMapping
    fun saveTipoSanguineo(@RequestBody tipoSanguineo: TipoSanguineo): ResponseEntity<TipoSanguineo> =
        ResponseEntity.status(HttpStatus.CREATED).body(tipoSanguineoService.saveTipoSanguineo(tipoSanguineo))

    @PutMapping("/{tipoSanguineoId}")
    fun updateTipoSanguineo(@PathVariable tipoSanguineoId: Long, @RequestBody updatedTipoSanguineo: TipoSanguineo): ResponseEntity<TipoSanguineo> {
        val tipoSanguineo = tipoSanguineoService.getUpdatedTipoSanguineo(tipoSanguineoId, updatedTipoSanguineo)
        return ResponseEntity.ok(tipoSanguineoService.saveTipoSanguineo(tipoSanguineo))
    }

    @DeleteMapping("/{tipoSanguineoId}")
    fun deleteTipoSanguineo(@PathVariable tipoSanguineoId: Long): ResponseEntity<String> {
        val tipoSanguineo = tipoSanguineoService.getTipoSanguineoById(tipoSanguineoId)
        tipoSanguineoService.deleteTipoSanguineo(tipoSanguineo.id!!)
        return ResponseEntity.ok("Tipo Sanguineo deletado com sucesso! -> $tipoSanguineo")
    }
}
