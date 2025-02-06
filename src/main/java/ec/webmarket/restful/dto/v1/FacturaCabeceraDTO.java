package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FacturaCabeceraDTO {
    private Long id;
    private ClienteDTO cliente;
    private LocalDate fecha;
}
