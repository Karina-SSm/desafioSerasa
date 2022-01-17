package com.br.Serasa.desafioSerasa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.Serasa.desafioSerasa.converter.DadosPessoasDTO;
import com.br.Serasa.desafioSerasa.converter.PessoaRequest;
import com.br.Serasa.desafioSerasa.converter.PessoaResumo;
import com.br.Serasa.desafioSerasa.dto.PessoaDTO;
import com.br.Serasa.desafioSerasa.model.Pessoa;
import com.br.Serasa.desafioSerasa.service.PessoaService;
import com.br.Serasa.desafioSerasa.util.ResourceUriUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Pessoas")
@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {
	
	    @Autowired
	    private PessoaService pessoaService;
	    @Autowired
	    private PessoaResumo pessoaResumo;
	    @Autowired
	    private PessoaRequest pessoaRequest;
	    @Autowired
	    private PessoaDTO pessoaDTO;
	    @Autowired
	    private DadosPessoasDTO dadosPessoasDTO;


	    @ApiOperation(value = "Listar Pessoas")
	    @GetMapping
	    public ResponseEntity<List<DadosPessoasDTO>> listar() {
	        List<Pessoa> pessoas = pessoaService.findAll();
	        return ResponseEntity.ok().body(dadosPessoasDTO.to(pessoas));
	    }
 
	    @ApiOperation(value = "Adicionar Pessoa")
	    @PostMapping
	    public ResponseEntity<Object> criar(@Valid @RequestBody PessoaRequest request) {
	        Pessoa pessoa = pessoaRequest.to(request);
	        pessoa = pessoaService.salvar(pessoa);
	        pessoaService.obterStatusScore(pessoa);
	        ResourceUriUtil.addUriInResponseHeader(pessoa.getId());
	        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO.to(pessoa));
	    }

	    @ApiOperation(value = "Buscar Pessoa Por ID")
	    @GetMapping("/{idPessoa}")
	    public ResponseEntity<PessoaResumo> buscar(@PathVariable Integer idPessoa) {
	        Pessoa pessoa = pessoaService.buscar(idPessoa);
	        pessoaService.obterStatusScore(pessoa);
	        return ResponseEntity.ok().body(pessoaResumo.to(pessoa));
	    }
}
