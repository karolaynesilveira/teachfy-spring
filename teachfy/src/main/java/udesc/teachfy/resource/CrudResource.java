package udesc.teachfy.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.controller.CrudController;
import udesc.teachfy.dto.Response;

@RestController
abstract public class CrudResource<M> {

	protected abstract CrudController<M> getController();

	@GetMapping
	public ResponseEntity<Response<List<M>>> all() {
		try {
			List<M> resultSet = getController().all();
			return new ResponseEntity(new Response("Dados encontrados com sucesso", resultSet), HttpStatus.OK);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<Response<M>> create(@RequestBody M record) {
		try {
			M newRecord = getController().create(record); 
			return new ResponseEntity(new Response("Registro salvo com sucesso", newRecord), HttpStatus.OK);
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<M>> show(@PathVariable Long id) {
		try {
			Optional<M> record = getController().show(id);
			if (!record.isEmpty()) {
				return new ResponseEntity(new Response("Registro encontrado com sucesso", record.get()), HttpStatus.OK);
			}
			return new ResponseEntity(new Response("Registro não encontrado"), HttpStatus.NOT_FOUND);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<M>> update(@RequestBody M record, @PathVariable Long id) {
		try {
			Optional<M> newRecord = getController().update(record, id);
			if (!newRecord.isEmpty()) {
				return new ResponseEntity(new Response("Registro alterado com sucesso", newRecord.get()), HttpStatus.OK);
			}
			return new ResponseEntity(new Response("Registro não encontrado"), HttpStatus.NOT_FOUND);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		try {
			getController().delete(id);
			return new ResponseEntity(new Response("Removido com sucesso"), HttpStatus.OK);
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
