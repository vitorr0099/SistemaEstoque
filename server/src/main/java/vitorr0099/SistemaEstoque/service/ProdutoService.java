package vitorr0099.SistemaEstoque.service;

import vitorr0099.SistemaEstoque.model.Produto;
import vitorr0099.SistemaEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Lista todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Busca um produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Salva um novo produto ou atualiza um existente
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Exclui um produto por ID
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}
