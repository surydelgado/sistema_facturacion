package ec.webmarket.restful.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Cliente;
import ec.webmarket.restful.dto.v1.ClienteDTO;
import ec.webmarket.restful.persistence.ClienteRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class ClienteService extends GenericCrudServiceImpl<Cliente, ClienteDTO> {
    @Autowired
    private ClienteRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Cliente> find(ClienteDTO dto) {
        return repository.findById(dto.getId());
    }

    @Override
    public Cliente mapToDomain(ClienteDTO dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    @Override
    public ClienteDTO mapToDto(Cliente domain) {
        return modelMapper.map(domain, ClienteDTO.class);
    }
    @Override
    public ClienteDTO create(ClienteDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("El ID debe ser nulo al crear un nuevo cliente");
        }
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }

        Cliente cliente = mapToDomain(dto);
        cliente = repository.save(cliente);
        
        return mapToDto(cliente);
    }

}