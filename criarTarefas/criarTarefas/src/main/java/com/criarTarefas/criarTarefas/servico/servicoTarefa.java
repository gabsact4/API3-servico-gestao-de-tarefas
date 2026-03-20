package com.criarTarefas.criarTarefas.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criarTarefas.criarTarefas.modelo.DTO.tarefaDTO;
import com.criarTarefas.criarTarefas.modelo.modeloTarefa;
import com.criarTarefas.criarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoTarefa {

    @Autowired
    private repositorioTarefa repositorioTarefa;

    public modeloTarefa criarTarefa(tarefaDTO dto) {
        modeloTarefa tarefa = new modeloTarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setResponsavel(dto.getResponsavel());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setStatus(dto.getStatus());
        

        return repositorioTarefa.save(tarefa);
    }
}
