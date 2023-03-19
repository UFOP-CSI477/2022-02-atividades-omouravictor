package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.Doacao
import com.omouravictor.blooddonationapi.services.DoacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doacoes")
class DoacaoController {

    @Autowired
    lateinit var doacaoService: DoacaoService

    @GetMapping
    fun getDoacoes(): ResponseEntity<List<Doacao>> = ResponseEntity.ok(doacaoService.getDoacoes())

    @GetMapping("/{doacaoId}")
    fun getDoacaoById(@PathVariable doacaoId: Long): ResponseEntity<Doacao> =
        ResponseEntity.ok(doacaoService.getDoacaoById(doacaoId))

    @GetMapping("/pessoa/{pessoaId}")
    fun getDoacoesByPessoaId(@PathVariable pessoaId: Long): ResponseEntity<List<Doacao>> =
        ResponseEntity.ok(doacaoService.getDoacoesByPessoaId(pessoaId))

    @GetMapping("/local-coleta/{localColetaId}")
    fun getDoacoesByLocalColetaId(@PathVariable localColetaId: Long): ResponseEntity<List<Doacao>> =
        ResponseEntity.ok(doacaoService.getDoacoesByLocalColetaId(localColetaId))

    @PostMapping
    fun saveDoacao(@RequestBody doacao: Doacao): ResponseEntity<Doacao> =
        ResponseEntity.status(HttpStatus.CREATED).body(doacaoService.saveDoacao(doacao))

    @PutMapping("/{doacaoId}")
    fun updateDoacao(@PathVariable doacaoId: Long, @RequestBody updatedDoacao: Doacao): ResponseEntity<Doacao> {
        val doacao = doacaoService.getUpdatedDoacao(doacaoId, updatedDoacao)
        return ResponseEntity.ok(doacaoService.saveDoacao(doacao))
    }

    @DeleteMapping("/{doacaoId}")
    fun deleteDoacao(@PathVariable doacaoId: Long): ResponseEntity<String> {
        val doacao = doacaoService.getDoacaoById(doacaoId)
        doacaoService.deleteDoacao(doacao.id!!)
        return ResponseEntity.ok("Doacao deletada com sucesso! -> $doacao")
    }
}
