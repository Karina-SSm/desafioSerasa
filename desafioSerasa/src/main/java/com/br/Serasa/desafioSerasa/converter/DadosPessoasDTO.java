package com.br.Serasa.desafioSerasa.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.Serasa.desafioSerasa.model.Pessoa;

@Component
public class DadosPessoasDTO {

	
	    @Autowired
	    private ModelMapper mapper;

	    public DadosPessoasDTO to(Pessoa pessoa) {
	        return mapper.map(pessoa, DadosPessoasDTO.class);
	    }

	    public List<DadosPessoasDTO> to(List<Pessoa> pessoas) {
	        return pessoas.stream()
	        		.map(pessoa -> to(pessoa))
	                .collect(Collectors.toList());
	    }
}
