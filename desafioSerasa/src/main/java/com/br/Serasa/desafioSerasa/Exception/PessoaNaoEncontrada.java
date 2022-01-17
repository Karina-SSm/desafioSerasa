package com.br.Serasa.desafioSerasa.Exception;



public class PessoaNaoEncontrada extends EntidadeNaoEncontradaException {
    public PessoaNaoEncontrada(String message) {
        super(message);
    }

    public PessoaNaoEncontrada(Integer idPessoa) {
        this(String.format("Não existe cadastro de pessoa com Id: %d", idPessoa));
    }
}
