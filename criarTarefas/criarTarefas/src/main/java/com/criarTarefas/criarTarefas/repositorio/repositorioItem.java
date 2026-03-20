package com.criarTarefas.criarTarefas.repositorio;
import com.criarTarefas.criarTarefas.modelo.modeloItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioItem extends JpaRepository<modeloItem, Long> {
    
}
