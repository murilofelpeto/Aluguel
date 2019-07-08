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

import br.com.murilo.aluguel.data.vo.InquilinoVO;
import br.com.murilo.aluguel.service.InquilinoService;

@RestController
@RequestMapping("/api/v1/inquilino")
public class InquilinoController {

	@Autowired
	private InquilinoService service;

	@GetMapping("/{id}")
	public InquilinoVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<InquilinoVO> createInquilino(@RequestBody InquilinoVO inquilino) {
		return new ResponseEntity<>(service.salvarInquilino(inquilino), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public InquilinoVO updateInquilino(@PathVariable(value = "id") Long id, InquilinoVO inquilino) {
		return service.updateInquilino(inquilino);
	}

	@DeleteMapping("/{id}")
	public void deleteInquilino(@PathVariable(value = "id") Long id) {
		service.deleteInquilino(id);
	}
}
