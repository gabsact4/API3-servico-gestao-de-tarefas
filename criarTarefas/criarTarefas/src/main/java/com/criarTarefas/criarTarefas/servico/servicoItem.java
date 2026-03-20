package com.criarTarefas.criarTarefas.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criarTarefas.criarTarefas.modelo.DTO.itemDTO;
import com.criarTarefas.criarTarefas.modelo.Item;
import com.criarTarefas.criarTarefas.modelo.Tarefa;
import com.criarTarefas.criarTarefas.repositorio.repositorioItem;
import com.criarTarefas.criarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoItem {

    @Autowired
    private repositorioItem repositorioItem;

    @Autowired
    private repositorioTarefa repositorioTarefa;

    public Item criarItem(itemDTO dto) {
        Tarefa tarefa = repositorioTarefa.findById(dto.getTarefaId())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        Item item = new Item();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setTarefa(tarefa);

        return repositorioItem.save(item);
    }
}
