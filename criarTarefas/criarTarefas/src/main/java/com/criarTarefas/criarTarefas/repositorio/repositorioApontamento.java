package com.criarTarefas.criarTarefas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criarTarefas.criarTarefas.modelo.modeloApontamento;

public interface repositorioApontamento extends JpaRepository<modeloApontamento, Long> {
    List<modeloApontamento> findByTarefaId(Long tarefaId);
}
