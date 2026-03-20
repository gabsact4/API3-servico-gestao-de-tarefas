package com.criarTarefas.criarTarefas.modelo.DTO;

import jakarta.validation.constraints.NotBlank;

public class tarefaDTO {

    @NotBlank(message = "O título da tarefa é obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição não pode estar vazia")
    private String descricao;

    @NotBlank(message = "Responsável é necessário")
    private String responsavel;

    @NotBlank(message = "Prazo é obrigatório")
    private String prazo;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
