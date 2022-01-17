package com.br.Serasa.desafioSerasa.model;


public enum ScoreDescricao {

    INSUFICIENTE("Insuficiente"),
    INACEITAVEL("Inaceitável"),
    ACEITAVEL("Aceitável"),
    RECOMENDAVEL("Recomendácel");


    private String descricao;

    ScoreDescricao(String descricao) {
        this.descricao = descricao;
    }
}
