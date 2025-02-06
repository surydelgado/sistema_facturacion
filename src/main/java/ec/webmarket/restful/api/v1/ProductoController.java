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

import ec.webmarket.restful.dto.v1.ProductoDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, service.findAll(new ProductoDTO())));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductoDTO dto) {
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.create(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, service.update(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(id);
        service.delete(dto);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Producto eliminado"));
    }
}