package com.udemy.compras.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@CrossOrigin("*")
@Component
public class ProdutoGraphQL implements GraphQLQueryResolver,GraphQLMutationResolver{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto produtoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    
    public Produto produtoByNome(String nome) {
		return  produtoRepository.findByNome(nome);
	}

    public List<Produto> produtoAll() {
        return produtoRepository.findAll();
    }

    public Produto saveProduto(Long id, String nome, int quantidade) {
        Produto prod = new Produto();
        prod.setId(id);
        prod.setNome(nome);
        prod.setQuantidade(quantidade);
        return produtoRepository.save(prod);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
