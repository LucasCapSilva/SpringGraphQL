package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Component
public class ClienteGraphQL implements GraphQLQueryResolver,GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente clienteById(Long id) {
        return clienteService.findById(id);
    }
    
    public Cliente clienteByNome(String nome) {
		return  clienteRepository.findByNome(nome);
	}

    public List<Cliente> clientesAll() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email) {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setEmail(email);
        return clienteService.save(c);
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }
}
