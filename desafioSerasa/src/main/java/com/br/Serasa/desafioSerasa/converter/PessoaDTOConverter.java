package com.br.Serasa.desafioSerasa.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.Serasa.desafioSerasa.dto.PessoaDTO;
import com.br.Serasa.desafioSerasa.model.Pessoa;



@Component
public class PessoaDTOConverter {

	  @Autowired
	    private ModelMapper mapper;

	    public PessoaDTO to(Pessoa pessoa) {
	        return mapper.map(pessoa, PessoaDTO.class);
	    }

	    public List<PessoaDTO> to(List<Pessoa> pessoas) {
	        return pessoas.stream()
	                .map(pessoa -> to(pessoa))
	                .collect(Collectors.toList());
	    }
}
