package com.criarTarefas.criarTarefas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criarTarefas.criarTarefas.modelo.DTO.apontamentoDTO;
import com.criarTarefas.criarTarefas.modelo.Item;
import com.criarTarefas.criarTarefas.modelo.Tarefa;
import com.criarTarefas.criarTarefas.modelo.modeloApontamento;
import com.criarTarefas.criarTarefas.repositorio.repositorioApontamento;
import com.criarTarefas.criarTarefas.repositorio.repositorioItem;
import com.criarTarefas.criarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoApontamento {

    @Autowired
    private repositorioApontamento repositorioApontamento;

    @Autowired
    private repositorioTarefa repositorioTarefa;

    @Autowired
    private repositorioItem repositorioItem;

    public modeloApontamento criarApontamento(apontamentoDTO dto) {
        Tarefa tarefa = repositorioTarefa.findById(dto.getTarefaId())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        Item item = repositorioItem.findById(dto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        modeloApontamento apontamento = new modeloApontamento();
        apontamento.setTarefa(tarefa);
        apontamento.setItem(item);
        apontamento.setDataHoraInicio(dto.getDataHoraInicio());
        apontamento.setDataHoraFim(dto.getDataHoraFim());
        apontamento.setTempoGastoMinutos(dto.getTempoGastoMinutos());
        apontamento.setDescricaoAtividade(dto.getDescricaoAtividade());

        return repositorioApontamento.save(apontamento);
    }

    public List<modeloApontamento> buscarPorTarefa(Long tarefaId) {
        return repositorioApontamento.findByTarefaId(tarefaId);
    }
}
