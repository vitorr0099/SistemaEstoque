package vitorr0099.SistemaEstoque.service;

import vitorr0099.SistemaEstoque.model.Usuario;
import vitorr0099.SistemaEstoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Busca um usuário por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Salva um novo usuário ou atualiza um existente
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Exclui um usuário por ID
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
