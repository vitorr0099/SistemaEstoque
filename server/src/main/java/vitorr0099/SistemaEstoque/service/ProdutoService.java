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

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setCodigo(produtoAtualizado.getCodigo());
            produto.setNome(produtoAtualizado.getNome());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            produto.setPrecoUnitario(produtoAtualizado.getPrecoUnitario());
            produto.setLocalizacao(produtoAtualizado.getLocalizacao());
            produto.setUnidadeMedida(produtoAtualizado.getUnidadeMedida());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
