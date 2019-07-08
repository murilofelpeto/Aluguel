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

import br.com.murilo.aluguel.data.vo.ProprietarioVO;
import br.com.murilo.aluguel.service.ProprietarioService;

@RestController
@RequestMapping("/api/v1/proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioService service;

	@GetMapping
	public ResponseEntity<List<ProprietarioVO>> findAll() {
		List<ProprietarioVO> proprietarios = service.findAll();
		return (proprietarios.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(proprietarios, HttpStatus.OK));
	}

	@GetMapping(value = "/{id}")
	public ProprietarioVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@GetMapping(value = "/findByName/{name}")
	public List<ProprietarioVO> findByName(@PathVariable(value = "name") String name) {
		return service.findByName(name);
	}

	@PostMapping
	public ResponseEntity<ProprietarioVO> create(@RequestBody ProprietarioVO proprietario) {
		return new ResponseEntity<>(service.create(proprietario), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<ProprietarioVO> updateProprietario(@RequestBody ProprietarioVO vo) {
		return new ResponseEntity<>(service.update(vo), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id")Long id) {
		service.delete(id);
	}
}
