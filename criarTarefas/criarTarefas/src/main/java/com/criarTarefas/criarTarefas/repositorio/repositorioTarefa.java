package com.criarTarefas.criarTarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criarTarefas.criarTarefas.modelo.modeloTarefa;

public interface repositorioTarefa extends JpaRepository<modeloTarefa, Long> {
    
}
