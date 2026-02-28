package com.anacr.forumhub.repository;

import com.anacr.forumhub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    // ✅ para atualizar sem acusar o próprio tópico como duplicado
    boolean existsByTituloAndMensagemAndIdNot(String titulo, String mensagem, Long id);
}
