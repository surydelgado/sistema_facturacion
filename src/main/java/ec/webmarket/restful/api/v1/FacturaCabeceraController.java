package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.webmarket.restful.dto.v1.FacturaCabeceraDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.FacturaCabeceraService;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaCabeceraController {
    @Autowired
    private FacturaCabeceraService service;

    @GetMapping("/listar")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponseDTO<>(true, service.findAll(new FacturaCabeceraDTO())));
    }
}

