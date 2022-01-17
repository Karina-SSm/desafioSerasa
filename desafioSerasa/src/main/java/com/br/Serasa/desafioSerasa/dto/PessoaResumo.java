package com.br.Serasa.desafioSerasa.dto;

import com.br.Serasa.desafioSerasa.model.ScoreDescricao;

public class PessoaResumo {
	
	 private String nome;
	    private String telefone;
	    private Integer idade;
	    private ScoreDescricao scoreDescricao;
	    
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
		public ScoreDescricao getScoreDescricao() {
			return scoreDescricao;
		}
		public void setScoreDescricao(ScoreDescricao scoreDescricao) {
			this.scoreDescricao = scoreDescricao;
		}

}
