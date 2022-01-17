package com.br.Serasa.desafioSerasa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.br.Serasa.desafioSerasa.Exception.PessoaNaoEncontrada;
import com.br.Serasa.desafioSerasa.model.Pessoa;
import com.br.Serasa.desafioSerasa.model.ScoreDescricao;
import com.br.Serasa.desafioSerasa.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        var pessoas= pessoaRepository.findAll();
        pessoas.forEach(this::obterStatusScore);

        return pessoas;
    }

    public Pessoa buscar(Integer idPessoa) {
        return pessoaRepository
                .findById(idPessoa)
                .orElseThrow(() -> new PessoaNaoEncontrada(idPessoa));
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void excluir(Integer idPessoa) {
        try {
            pessoaRepository.deleteById(idPessoa);
        } catch (EmptyResultDataAccessException e) {
            throw new PessoaNaoEncontrada(idPessoa);
        }
    }

    public void obterStatusScore(Pessoa pessoa) {
        if (pessoa.getScore() >= 0 && pessoa.getScore() <= 200) {
            pessoa.setScoreDescricao(ScoreDescricao.INSUFICIENTE);
        } else if (pessoa.getScore() <= 500) {
            pessoa.setScoreDescricao(ScoreDescricao.INACEITAVEL);
        } else if (pessoa.getScore() <= 700) {
            pessoa.setScoreDescricao(ScoreDescricao.ACEITAVEL);
        } else if (pessoa.getScore() <= 1000) {
            pessoa.setScoreDescricao(ScoreDescricao.RECOMENDAVEL);
        }

     }
}
