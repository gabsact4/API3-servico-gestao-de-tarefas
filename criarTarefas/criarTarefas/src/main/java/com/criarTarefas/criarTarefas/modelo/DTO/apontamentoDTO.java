package com.criarTarefas.criarTarefas.modelo.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class apontamentoDTO {
    
    @NotNull(message = "ID da tarefa é obrigatório")
    private Long tarefaId;
    
    @NotNull(message = "ID do item é obrigatório")
    private Long itemId;
    
    private LocalDateTime dataHoraInicio;
    
    private LocalDateTime dataHoraFim;
    
    @NotNull(message = "Tempo gasto é obrigatório")
    @Positive(message = "Tempo gasto deve ser positivo")
    private Integer tempoGastoMinutos;
    
    private String descricaoAtividade;

    public Long getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(Long tarefaId) {
        this.tarefaId = tarefaId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Integer getTempoGastoMinutos() {
        return tempoGastoMinutos;
    }

    public void setTempoGastoMinutos(Integer tempoGastoMinutos) {
        this.tempoGastoMinutos = tempoGastoMinutos;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    
}
