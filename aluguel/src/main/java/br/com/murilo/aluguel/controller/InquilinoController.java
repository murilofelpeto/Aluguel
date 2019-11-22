package br.com.murilo.aluguel.controller;

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

import br.com.murilo.aluguel.dto.request.InquilinoRequest;
import br.com.murilo.aluguel.dto.response.InquilinoResponse;
import br.com.murilo.aluguel.facade.InquilinoFacade;

@RestController
@RequestMapping("/api/v1/inquilino")
public class InquilinoController {

	@Autowired
	private InquilinoFacade inquilinoFacade;

	@GetMapping("/{id}")
	public ResponseEntity<InquilinoResponse> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(inquilinoFacade.findById(id), HttpStatus.OK);
	}

	@GetMapping("/documento/{cpf}")
	public ResponseEntity<InquilinoResponse> findByCpf(@PathVariable(value = "cpf") Long cpf) {
		return new ResponseEntity<>(inquilinoFacade.findByCpf(cpf), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<InquilinoResponse> createInquilino(@RequestBody InquilinoRequest inquilino) {
		return new ResponseEntity<>(inquilinoFacade.salvarInquilino(inquilino), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<InquilinoResponse> updateInquilino(@PathVariable(value = "id") Long idInquilino, @RequestBody InquilinoRequest inquilino) {
		return new ResponseEntity<>(inquilinoFacade.updateInquilino(idInquilino, inquilino), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteInquilino(@PathVariable(value = "id") Long id) {
		inquilinoFacade.deleteInquilino(id);
	}
}
