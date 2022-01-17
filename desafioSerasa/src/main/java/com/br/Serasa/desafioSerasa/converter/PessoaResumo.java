package com.br.Serasa.desafioSerasa.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.Serasa.desafioSerasa.model.Pessoa;

@Component
public class PessoaResumo {
	
	   @Autowired
	    private ModelMapper mapper;

	    public PessoaResumo to(Pessoa pessoa) {
	        return mapper.map(pessoa, PessoaResumo.class);
	    }

}
