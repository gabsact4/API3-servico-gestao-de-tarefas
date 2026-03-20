package com.criarTarefas.criarTarefas.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.criarTarefas.criarTarefas.modelo.modeloTipoTarefa;

public interface repositorioTipoTarefa extends JpaRepository<modeloTipoTarefa, Long> {
    
}
