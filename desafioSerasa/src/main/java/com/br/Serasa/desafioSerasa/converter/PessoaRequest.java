package com.br.Serasa.desafioSerasa.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.Serasa.desafioSerasa.model.Pessoa;

@Component
public class PessoaRequest {

	@Autowired
    private ModelMapper mapper;

    public Pessoa to(PessoaRequest request) {
        return mapper.map(request, Pessoa.class);
    }

}
