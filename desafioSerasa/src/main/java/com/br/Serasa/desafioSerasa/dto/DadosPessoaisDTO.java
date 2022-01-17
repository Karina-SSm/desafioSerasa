package com.br.Serasa.desafioSerasa.dto;

import com.br.Serasa.desafioSerasa.model.ScoreDescricao;

public class DadosPessoaisDTO {

	
	 private String nome;
	 private String cidade;
	 private String estado;
	 private ScoreDescricao scoreDescricao;
	 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ScoreDescricao getScoreDescricao() {
		return scoreDescricao;
	}
	public void setScoreDescricao(ScoreDescricao scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}
}
