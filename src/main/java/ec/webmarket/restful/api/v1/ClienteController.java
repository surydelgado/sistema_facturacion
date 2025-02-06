package ec.webmarket.restful.api.v1;

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

import ec.webmarket.restful.dto.v1.ClienteDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, service.findAll(new ClienteDTO())));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteDTO dto) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.create(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, service.update(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(id);
        service.delete(dto);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Cliente eliminado"));
    }
}