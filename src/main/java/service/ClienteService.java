package service;

import javax.script.Invocable;

import ch.qos.logback.core.net.server.Client;
import model.Cliente;

public interface ClienteService {

	Iterable<Client> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);

	void inserir (Cliente cliente);
}
