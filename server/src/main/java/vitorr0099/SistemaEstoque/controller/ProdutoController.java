package vitorr0099.SistemaEstoque.controller;

import vitorr0099.SistemaEstoque.dto.ProdutoDTO;
import vitorr0099.SistemaEstoque.model.Produto;
import vitorr0099.SistemaEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Converter Produto para ProdutoDTO
    private ProdutoDTO convertToDto(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getCodigo(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPrecoUnitario(),
                produto.getLocalizacao(),
                produto.getUnidadeMedida()
        );
    }

    // Converter ProdutoDTO para Produto
    private Produto convertToEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setNome(produtoDTO.getNome());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        produto.setLocalizacao(produtoDTO.getLocalizacao());
        produto.setUnidadeMedida(produtoDTO.getUnidadeMedida());
        return produto;
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return produtos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO obterProduto(@PathVariable Long id) {
        Produto produto = produtoService.obterProduto(id);
        return convertToDto(produto);
    }

    @PostMapping
    public ProdutoDTO adicionarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return convertToDto(produtoSalvo);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return convertToDto(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}