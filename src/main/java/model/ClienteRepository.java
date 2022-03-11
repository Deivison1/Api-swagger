package model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.net.server.Client;

@Repository
public interface ClienteRepository extends CrudRepository<Client, Long>{

	void save(Cliente cliente);

	
}
