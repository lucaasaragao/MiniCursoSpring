package br.ufpb.minicurso.api1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.minicurso.api1.entidades.Disciplina;
import br.ufpb.minicurso.api1.servicos.DisciplinasService;

/* */


@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService disciplinaService;
	private int id;
	private double nota;
	
	@GetMapping("/v2/api/entra") //Ver disciplinas já instaciadas
	public ResponseEntity<Disciplina> getDisciplina(@RequestParam(value = "nome", defaultValue = "Disciplina") String nome){
		return new ResponseEntity<Disciplina>(disciplinaService.getDisciplina(nome, id, nota), HttpStatus.OK);
	}
	
	@PostMapping("/v2/api/disciplinas") // Publicar um disciplina
	public ResponseEntity<Disciplina> setNovaDisciplina(@RequestBody Disciplina novaDisciplina){
		return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(novaDisciplina), HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/lista/disciplinas") //Listar disciplinas
	public ResponseEntity<Disciplina> getNovaDisciplina(@RequestParam(value="nome", defaultValue = "Disciplina")String nome){
		return new ResponseEntity<Disciplina>(disciplinaService.getNovaDisciplina(nome, id, nota), HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/lista/disciplinas/{id}")
	public ResponseEntity<Disciplina> getNovaDisiciplina(@PathVariable Integer id, @RequestParam(value="nome", defaultValue="Disciplina")String nome){
		try {
			return new ResponseEntity<Disciplina>(disciplinaService.getNovaDisciplina(nome, id, nota), HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(nome, id, nota), HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}") //Deleta uma disciplina
	public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable Integer id){
		return new ResponseEntity<Disciplina>(disciplinaService.deleteDisciplina(id), HttpStatus.OK);
	}
	
	@PutMapping ("/v1/api/lista/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> setNovoNomeDisciplina(@RequestBody Disciplina nome){
		return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(nome), HttpStatus.OK);
	}
	
	@PutMapping ("/v1/api/lista/disciplinas/{id}/id")
	public ResponseEntity<Disciplina> setNovoIdDisciplina(@RequestBody Disciplina id){
		return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(id), HttpStatus.OK);
	}
	
	@PutMapping ("/v1/api/lista/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> setNovoNotaDisciplina(@RequestBody Disciplina nota){
		return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(nota), HttpStatus.OK);
	}
	
	
	
}
