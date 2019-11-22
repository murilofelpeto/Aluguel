package br.com.murilo.aluguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.aluguel.dto.request.ProprietarioRequest;
import br.com.murilo.aluguel.dto.response.ProprietarioResponse;
import br.com.murilo.aluguel.dto.response.ProprietarioVO;
import br.com.murilo.aluguel.facade.ProprietarioFacade;
import br.com.murilo.aluguel.service.ProprietarioService;

@RestController
@RequestMapping("/api/v1/proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioFacade proprietarioFacade;

	@GetMapping
	public ResponseEntity<List<ProprietarioResponse>> findAll() {
		List<ProprietarioResponse> proprietarios = proprietarioFacade.findAll();
		return (proprietarios.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(proprietarios, HttpStatus.OK));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProprietarioResponse> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(proprietarioFacade.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/findByName/{name}")
	public ResponseEntity<List<ProprietarioResponse>> findByName(@PathVariable(value = "name") String name) {
		List<ProprietarioResponse> proprietarios = proprietarioFacade.findByName(name); 
		return (proprietarios.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(proprietarios, HttpStatus.OK));
	}

	@PostMapping
	public ResponseEntity<ProprietarioResponse> create(@RequestBody ProprietarioRequest proprietario) {
		return new ResponseEntity<>(proprietarioFacade.create(proprietario), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProprietarioResponse> updateProprietario(@PathVariable(value = "id") Long id, @RequestBody ProprietarioRequest proprietario) {
		return new ResponseEntity<>(proprietarioFacade.update(id, proprietario), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id")Long id) {
		proprietarioFacade.delete(id);
	}
}
