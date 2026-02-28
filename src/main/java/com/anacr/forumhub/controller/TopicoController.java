package com.anacr.forumhub.controller;

import com.anacr.forumhub.domain.topico.Topico;
import com.anacr.forumhub.dto.DadosAtualizacaoTopico;
import com.anacr.forumhub.dto.DadosDetalhamentoTopico;
import com.anacr.forumhub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        Optional<Topico> optionalTopico = repository.findById(id);

        // ✅ Regra: verificar se o ID existe
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        // ✅ Regra: não permitir duplicado (mesmo título + mensagem), ignorando o próprio registro
        boolean duplicado = repository.existsByTituloAndMensagemAndIdNot(
                dados.titulo(),
                dados.mensagem(),
                id
        );

        if (duplicado) {
            return ResponseEntity.badRequest().body("Tópico duplicado!");
        }

        Topico topico = optionalTopico.get();

        topico.atualizar(
                dados.titulo(),
                dados.mensagem(),
                dados.autor(),
                dados.curso()
        );

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    // ✅ DELETE - Excluir tópico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {

        Optional<Topico> optionalTopico = repository.findById(id);

        // ✅ Regra: verificar se o ID existe
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build(); // 204
    }
}