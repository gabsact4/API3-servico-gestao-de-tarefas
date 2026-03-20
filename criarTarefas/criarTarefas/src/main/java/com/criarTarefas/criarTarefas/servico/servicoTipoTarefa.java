package com.criarTarefas.criarTarefas.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criarTarefas.criarTarefas.modelo.DTO.tarefaTipoDTO;
import com.criarTarefas.criarTarefas.modelo.modeloTipoTarefa;
import com.criarTarefas.criarTarefas.repositorio.repositorioTipoTarefa;

@Service
public class servicoTipoTarefa {

    @Autowired
    private repositorioTipoTarefa repositorioTipoTarefa;

    public modeloTipoTarefa criarTipoTarefa(tarefaTipoDTO dto) {
        modeloTipoTarefa tipoTarefa = new modeloTipoTarefa();
        tipoTarefa.setNome(dto.getNome());
        return repositorioTipoTarefa.save(tipoTarefa);
    }
}
