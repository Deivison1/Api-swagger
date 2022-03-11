package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.GetMapping;

import feign.Request;
import model.Endereco;

@FeignClient(name = "viacep", url = "viacep.com.br/ws/01001000/json/")
public interface ViaCepService {

	@RepositoryMapping(method = RequestMethod.GET, value = "{cep}/json")
	Endereco consultarCep(@PathVariable("cep") String cep);
}
