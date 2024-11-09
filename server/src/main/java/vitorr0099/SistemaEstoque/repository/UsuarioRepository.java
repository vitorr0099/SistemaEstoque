package vitorr0099.SistemaEstoque.repository;

import vitorr0099.SistemaEstoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
