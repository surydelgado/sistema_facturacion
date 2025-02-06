package ec.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.webmarket.restful.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}

