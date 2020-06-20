package ufpb.minicurso.ex1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.ex1.entidades.Saudacao;
import ufpb.minicurso.ex1.servicos.SaudacoesService;

/*
 * Resumo da API REST
 * 
 * GET /v1/api/saudacoes
 * retorna uma saudação: saudacao (String) que é sempre "Oi" e um 
 * nome (String) que pode ser o padrão "Ser Humano" ou pode ser passado 
 * como parâmetro da requisição. 
 * 
 *  GET /v1/api/saudacoes/hora
 *  retorna uma saudação com base na hora: "Bom dia" quando está de manhã, 
 *  "Boa tarde" quando está de tarde e "Boa noite" quando está de noite. O 
 *  nome retornado pode ser o padrão "Ser Humano" ou o nome recebido no
 *  parâmetro da requisição.
 *  
 *  POST /v1/api/saudacoes/alternativa
 *  permite que uma nova saudação alternativa seja adicionada ao sistema. 
 *  Não há limite para o número de saudações alternativas que podem ser 
 *  adicionadas (e isso pode ser um problema). Não há persistência, quando
 *  o sistema reiniciar as saudações alternativas serão perdidas. Também 
 *  retorna um nome. O nome retornado pode ser o padrão "Ser Humano" ou o 
 *  nome recebido no parâmetro da requisição.
 *  
 *  GET /v1/api/saudacoes/alternativa/{id}
 *  retorna idésima saudação cadastrada e um nome. O nome retornado pode ser 
 *  o padrão "Ser Humano" ou o nome recebido no parâmetro da requisição. Se 
 *  o id passado não corresponder a uma saudação válida o código de resposta
 *  HTTP 403 é retornado junto com uma saudação nula.
 */


@RestController
public class SaudacoesController {
	
	
	@Autowired
	private SaudacoesService saudacoesService;
	
	@GetMapping("/v1/api/saudacoes") /*URL responsaval por chamar o metodo http*/
	public ResponseEntity<Saudacao> getSaudacao(@RequestParam(value= "nome", defaultValue = "Ser Humano")String nome){
		return new ResponseEntity<Saudacao>(saudacoesService.getSaudacao(nome), HttpStatus.OK);
	}
	
	
	@GetMapping("/v1/api/saudacoes/hora")
	public ResponseEntity<Saudacao> getSaudacaoTemporal(@RequestParam(value= "nome", defaultValue = "Ser Humano")String nome){
		return new ResponseEntity<Saudacao>(saudacoesService.getSaudacaoTemporal(nome), HttpStatus.OK);
	}
	
	
	@PostMapping("/v1/api/saudacoes/alternativa")
	public ResponseEntity<Saudacao> setNovaSaudacao(@RequestBody Saudacao novaSaudacao){
		//System.out.println(novaSaudacao);
		return new ResponseEntity<Saudacao>(saudacoesService.setNovaSaudacao(novaSaudacao), HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/saudacoes/alternativa")
	public ResponseEntity<Saudacao> getNovaSaudacao(@RequestParam(value= "nome", defaultValue = "Ser Humano")String nome){
		return new ResponseEntity<Saudacao>(saudacoesService.getNovaSaudacao(nome, 0), HttpStatus.OK);
		
	}
	
	@GetMapping("/v1/api/saudacoes/alternativa{id}")
	public ResponseEntity<Saudacao> getNovaSaudacao(@PathVariable Integer id, @RequestParam(value= "nome", defaultValue = "Ser Humano")String nome){
		try {
			return new ResponseEntity<Saudacao>(saudacoesService.getNovaSaudacao(nome, id), HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Saudacao>(new Saudacao(null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

}
