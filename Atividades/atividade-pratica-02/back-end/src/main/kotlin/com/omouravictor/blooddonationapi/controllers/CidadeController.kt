package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.Cidade
import com.omouravictor.blooddonationapi.services.CidadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cidades")
class CidadeController {

    @Autowired
    lateinit var cidadeService: CidadeService

    @GetMapping
    fun getCidades(): ResponseEntity<List<Cidade>> = ResponseEntity.ok(cidadeService.getCidades())

    @GetMapping("/{cidadeId}")
    fun getCidadeById(@PathVariable cidadeId: Long): ResponseEntity<Cidade> =
        ResponseEntity.ok(cidadeService.getCidadeById(cidadeId))

    @GetMapping("/estado/{estadoId}")
    fun getCidadesByEstadoId(@PathVariable estadoId: Long): ResponseEntity<List<Cidade>> =
        ResponseEntity.ok(cidadeService.getCidadesByEstadoId(estadoId))

    @PostMapping
    fun saveCidade(@RequestBody cidade: Cidade): ResponseEntity<Cidade> =
        ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.saveCidade(cidade))

    @PutMapping("/{cidadeId}")
    fun updateCidade(@PathVariable cidadeId: Long, @RequestBody updatedCidade: Cidade): ResponseEntity<Cidade> {
        val cidade = cidadeService.getUpdatedCidade(cidadeId, updatedCidade)
        return ResponseEntity.ok(cidadeService.saveCidade(cidade))
    }

    @DeleteMapping("/{cidadeId}")
    fun deleteCidade(@PathVariable cidadeId: Long): ResponseEntity<String> {
        val cidade = cidadeService.getCidadeById(cidadeId)
        cidadeService.deleteCidade(cidade.id!!)
        return ResponseEntity.ok("Cidade deletada com sucesso! -> $cidade")
    }
}
