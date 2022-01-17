package com.br.Serasa.desafioSerasa.service;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.Serasa.desafioSerasa.model.Pessoa;
import com.br.Serasa.desafioSerasa.repository.PessoaRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.br.Serasa.desafioSerasa.util.ResourceUtil;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaServiceTest {

    @LocalServerPort
    private int port;
    @Autowired
    private PessoaRepository pessoaRepository;
    private String jsonPessoaCorreto;
    private Pessoa pessoa;

    @Before
    public void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port=port;
        basePath="/v1/pessoas";
        jsonPessoaCorreto = ResourceUtil.getContentFromResource("/json/pessoa.json");
        prepararDados();
    }
    
    @Test
    public void deveRetornarStatus200_QuandoConsultarPessoas() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    
    @Test
    public void deveRetornarRespostaEStatusCorretos_QuandoConsultarPessoaExistente() {
        given()
                .pathParam("idPessoa", pessoa.getId())
                .accept(ContentType.JSON)
                .when()
                .get("/{idPessoa}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", Matchers.equalTo(pessoa.getNome()));
    }

    @Test
    public void deveRetornarStatus201_QuandoCadastrarPessoa() {
        given()
                .body(jsonPessoaCorreto)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    private void prepararDados() {
        pessoa = new Pessoa();
        pessoa.setNome("Karina Souza");
        pessoa.setIdade(25);
        pessoa.setTelefone("11988384755");
        pessoa.setCidade("São Paulo");
        pessoa.setEstado("SP");
        pessoa.setScore(900);

       pessoaRepository.save(pessoa);
    }

}
