package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.core.net.server.Client;
import model.Cliente;
import model.ClienteRepository;
import model.Endereco;
import model.EnderecoRepository;

public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private  EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	
	
	
	@Override
	public Iterable<Client> buscarTodos() {
		
		return clienteRepository.findAll();
	}
	

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Client> cliente = clienteRepository.findById(id);
		
		return (Cliente) cliente.get();
	}
	
    private void preencherClienteCep(Cliente cliente) {
		// Verificar se o Endereco do cliente já existe (pelo cep)
    String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCep e persistir no retorno
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
	}
    @Override
	public void inserir(Cliente cliente) {
		preencherClienteCep(cliente);
		
    }	

	@Override
	public void atualizar(Long id, Cliente cliente) {
		//Buscar Cliente por Id, caso Wxista.
		
		Optional<Client> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			preencherClienteCep(cliente);
		}
		
	}

	@Override
	public void deletar(Long id) {
		
		//Deletar Cliente por Id.
		
		clienteRepository.deleteById(id);
		
	}

}
