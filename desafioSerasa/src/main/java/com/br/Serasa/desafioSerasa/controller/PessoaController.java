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
import com.br.Serasa.desafioSerasa.converter.DadosPessoasDTOConverter;
import com.br.Serasa.desafioSerasa.converter.PessoaDTOConverter;
import com.br.Serasa.desafioSerasa.converter.PessoaRequestConverter;
import com.br.Serasa.desafioSerasa.converter.PessoaResumoDTOConverter;
import com.br.Serasa.desafioSerasa.dto.PessoaDTO;
import com.br.Serasa.desafioSerasa.dto.PessoaRequest;
import com.br.Serasa.desafioSerasa.dto.PessoaResumoDTO;
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
    private PessoaResumoDTOConverter pessoaResumoDTOConverter;
    @Autowired
    private PessoaRequestConverter pessoaRequestConverter;
    @Autowired
    private PessoaDTOConverter pessoaDTOConverter;
    @Autowired
    private DadosPessoasDTOConverter dadosPessoasDTOConverter;


    @ApiOperation(value = "Listar Pessoas")
    @GetMapping
    public ResponseEntity<List<com.br.Serasa.desafioSerasa.dto.DadosPessoasDTO>> listar() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.ok().body(dadosPessoasDTOConverter.to(pessoas));
    }

    @ApiOperation(value = "Adicionar Pessoa")
    @PostMapping
    public ResponseEntity<PessoaDTO> criar(@Valid @RequestBody PessoaRequest request) {
        Pessoa pessoa = pessoaRequestConverter.to(request);
        pessoa = pessoaService.salvar(pessoa);
        pessoaService.obterStatusScore(pessoa);
        ResourceUriUtil.addUriInResponseHeader(pessoa.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTOConverter.to(pessoa));
    }

    @ApiOperation(value = "Buscar Pessoa Por ID")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaResumoDTO> buscar(@PathVariable Integer idPessoa) {
        Pessoa pessoa = pessoaService.buscar(idPessoa);
        pessoaService.obterStatusScore(pessoa);
        return ResponseEntity.ok().body(pessoaResumoDTOConverter.to(pessoa));
    
    }
}