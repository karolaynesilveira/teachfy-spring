package udesc.teachfy.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import udesc.teachfy.dto.Response;

@CrossOrigin(origins="http://localhost:5173")
@RestController
abstract public class CrudResource<M> {

	protected abstract JpaRepository<M, Long> getRepository();

	@GetMapping
	public ResponseEntity<Response<List<M>>> all() {
		try {
			List<M> records = getRepository().findAll();
			records.forEach((record) -> { 
				updateDataForResponse(record);
			});
			return new ResponseEntity(new Response("Dados encontrados com sucesso", records), HttpStatus.OK);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<Response<M>> create(@RequestBody M record) {
		try {
			setDataForCreate(record);
			M newRecord = getRepository().saveAndFlush(record); 
			updateDataForResponse(newRecord);
			return new ResponseEntity(new Response("Registro salvo com sucesso", newRecord), HttpStatus.OK);
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	protected void setDataForCreate(M record) {}
	protected void updateDataForResponse(M record) {}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<M>> show(@PathVariable Long id) {
		try {
			Optional<M> record = getRepository().findById(id);
			if (!record.isEmpty()) {
				updateDataForResponse(record.get());
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
			Optional<M> newRecord = getRepository().findById(id);
			if (!newRecord.isEmpty()) {
				M older = newRecord.get();
				setDataForUpdate(older, record);
				getRepository().saveAndFlush(older);
				updateDataForResponse(older);
				return new ResponseEntity(new Response("Registro alterado com sucesso", older), HttpStatus.OK);
			}
			return new ResponseEntity(new Response("Registro não encontrado"), HttpStatus.NOT_FOUND);			
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	protected void setDataForUpdate(M older, M newer) {}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		try {
			getRepository().deleteById(id);
			return new ResponseEntity(new Response("Removido com sucesso"), HttpStatus.OK);
		} catch (Exception except) {
			return new ResponseEntity(new Response(except.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
