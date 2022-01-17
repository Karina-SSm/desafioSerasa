package com.br.Serasa.desafioSerasa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id", nullable = false)
	 private Integer id;
	 
	 @Column(name = "nome", nullable = false, length = 100)
	    private String nome;

	    @Column(name = "telefone", nullable = false, length = 45)
	    private String telefone;

	    @Column(name = "idade", nullable = false)
	    private Integer idade;

	    @Column(name = "cidade", nullable = false, length = 30)
	    private String cidade;

	    @Column(name = "estado", nullable = false, length = 2)
	    private String estado;

	    @Column(name = "score", nullable = false)
	    private Integer score;
	    
	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

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

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;

       }
}
