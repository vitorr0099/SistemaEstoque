package vitorr0099.SistemaEstoque.repository;

import vitorr0099.SistemaEstoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
    List<Produto> findByNomeContainingIgnoreCaseOrCodigoContainingIgnoreCase(String nome, String codigo);

}