package com.omouravictor.blooddonationapi.controllers

import com.omouravictor.blooddonationapi.entities.Pessoa
import com.omouravictor.blooddonationapi.services.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController {

    @Autowired
    lateinit var pessoaService: PessoaService

    @GetMapping
    fun getPessoas(): ResponseEntity<List<Pessoa>> = ResponseEntity.ok(pessoaService.getPessoas())

    @GetMapping("/{pessoaId}")
    fun getPessoaById(@PathVariable pessoaId: Long): ResponseEntity<Pessoa> =
        ResponseEntity.ok(pessoaService.getPessoaById(pessoaId))

    @GetMapping("/cidade/{cidadeId}")
    fun getPessoasByCidadeId(@PathVariable cidadeId: Long): ResponseEntity<List<Pessoa>> =
        ResponseEntity.ok(pessoaService.getPessoasByCidadeId(cidadeId))

    @GetMapping("/tipo-sanguineo/{tipoSanguineoId}")
    fun getPessoasByTipoSanguineoId(@PathVariable tipoSanguineoId: Long): ResponseEntity<List<Pessoa>> =
        ResponseEntity.ok(pessoaService.getPessoasByTipoSanguineoId(tipoSanguineoId))

    @PostMapping
    fun savePessoa(@RequestBody pessoa: Pessoa): ResponseEntity<Pessoa> =
        ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(pessoa))

    @PutMapping("/{pessoaId}")
    fun updatePessoa(@PathVariable pessoaId: Long, @RequestBody updatedPessoa: Pessoa): ResponseEntity<Pessoa> {
        val pessoa = pessoaService.getUpdatedPessoa(pessoaId, updatedPessoa)
        return ResponseEntity.ok(pessoaService.savePessoa(pessoa))
    }

    @DeleteMapping("/{pessoaId}")
    fun deletePessoa(@PathVariable pessoaId: Long): ResponseEntity<String> {
        val pessoa = pessoaService.getPessoaById(pessoaId)
        pessoaService.deletePessoa(pessoa.id!!)
        return ResponseEntity.ok("Pessoa deletada com sucesso! -> $pessoa")
    }
}
