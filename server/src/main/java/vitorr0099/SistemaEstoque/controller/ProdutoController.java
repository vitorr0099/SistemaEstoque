package vitorr0099.SistemaEstoque.controller;

import vitorr0099.SistemaEstoque.dto.ProdutoDTO;
import vitorr0099.SistemaEstoque.model.Produto;
import vitorr0099.SistemaEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
    public List<Produto> listarProdutos(@RequestParam(value = "search", defaultValue = "") String search) {
        List<Produto> produtos = produtoService.listarProdutos(search);

        return produtoService.listarProdutos(search);

    }

    @GetMapping("/{id}")
    public ProdutoDTO obterProduto(@PathVariable Long id) {
        Produto produto = produtoService.obterProduto(id);
        return convertToDto(produto);
    }
    @PostMapping
    public ResponseEntity<ProdutoDTO> adicionarProduto(@RequestBody ProdutoDTO produtoDTO) {
        if (produtoDTO.getCodigo() == null || produtoDTO.getCodigo().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Retorne um erro se o código for inválido
        }

        Produto produto = convertToEntity(produtoDTO);
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return ResponseEntity.ok(convertToDto(produtoSalvo));
    }


    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return convertToDto(produtoAtualizado);
    }




    // Método para excluir produto
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("codigo") Long id) {
        boolean deleted = produtoService.deleteProduto(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}