package com.criarTarefas.criarTarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criarTarefas.criarTarefas.modelo.Tarefa;

public interface repositorioTarefa extends JpaRepository<Tarefa, Long> {
    
}
