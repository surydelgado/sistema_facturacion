package ec.webmarket.restful.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Producto;
import ec.webmarket.restful.dto.v1.ProductoDTO;
import ec.webmarket.restful.persistence.ProductoRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class ProductoService extends GenericCrudServiceImpl<Producto, ProductoDTO> {
    @Autowired
    private ProductoRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Producto> find(ProductoDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Producto mapToDomain(ProductoDTO dto) {
        return modelMapper.map(dto, Producto.class);
    }

    @Override
    public ProductoDTO mapToDto(Producto domain) {
        return modelMapper.map(domain, ProductoDTO.class);
    }
    
    @Override
    public ProductoDTO create(ProductoDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("El ID debe ser nulo al crear un nuevo producto");
        }

        Producto producto = mapToDomain(dto);
        producto = repository.save(producto);
        
        return mapToDto(producto);
    }

}