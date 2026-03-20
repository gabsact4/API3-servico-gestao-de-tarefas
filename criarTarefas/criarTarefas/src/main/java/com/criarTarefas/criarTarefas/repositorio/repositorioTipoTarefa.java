package com.criarTarefas.criarTarefas.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.criarTarefas.criarTarefas.modelo.TipoTarefa;

public interface repositorioTipoTarefa extends JpaRepository<TipoTarefa, Long> {
    
}
