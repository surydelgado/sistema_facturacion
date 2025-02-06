package ec.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.webmarket.restful.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}