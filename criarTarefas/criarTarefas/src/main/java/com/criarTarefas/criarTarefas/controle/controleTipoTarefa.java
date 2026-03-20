package com.criarTarefas.criarTarefas.controle;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.criarTarefas.criarTarefas.modelo.DTO.tarefaTipoDTO;
import com.criarTarefas.criarTarefas.modelo.modeloTipoTarefa;
import com.criarTarefas.criarTarefas.servico.servicoTipoTarefa;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipoTarefa")
public class controleTipoTarefa {

    @Autowired
    private servicoTipoTarefa servicoTipoTarefa;

    @PostMapping
    public ResponseEntity<modeloTipoTarefa> criarTipoTarefa(@Valid @RequestBody tarefaTipoDTO dto) {
        modeloTipoTarefa tipoTarefaCriada = servicoTipoTarefa.criarTipoTarefa(dto);
        return ResponseEntity.ok(tipoTarefaCriada);
    }
}
