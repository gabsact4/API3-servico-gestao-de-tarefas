package com.criarTarefas.criarTarefas.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criarTarefas.criarTarefas.modelo.DTO.tarefaDTO;
import com.criarTarefas.criarTarefas.modelo.Tarefa;
import com.criarTarefas.criarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoTarefa {

    @Autowired
    private repositorioTarefa repositorioTarefa;

    public Tarefa criarTarefa(tarefaDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setResponsavel(dto.getResponsavel());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setStatus(dto.getStatus());
        

        return repositorioTarefa.save(tarefa);
    }
}
