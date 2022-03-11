package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import service.ClienteService;

@RestController
@RequestMapping("clientes")

public class ClienteRest<Cliente> {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Iterable<model.Cliente>> buscarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<model.Cliente> buscaPorId(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
    	clienteService.inserir((model.Cliente) cliente);
    	return ResponseEntity.ok(cliente);
    }
    @PutMapping
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
		return ResponseEntity.ok(cliente);
    	
   }
    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable Long id){
    	clienteService.deletar(id);
    	return ResponseEntity.ok().build();
    }
  }
