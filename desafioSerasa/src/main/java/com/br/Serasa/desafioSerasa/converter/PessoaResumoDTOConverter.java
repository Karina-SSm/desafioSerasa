package com.br.Serasa.desafioSerasa.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.Serasa.desafioSerasa.dto.PessoaResumoDTO;
import com.br.Serasa.desafioSerasa.model.Pessoa;

@Component
public class PessoaResumoDTOConverter {
	
	   @Autowired
	    private ModelMapper mapper;

	    public PessoaResumoDTO to(Pessoa pessoa) {
	        return mapper.map(pessoa, PessoaResumoDTO.class);
	    }

}
