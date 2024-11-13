package vitorr0099.SistemaEstoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitorr0099.SistemaEstoque.model.Usuario;
import vitorr0099.SistemaEstoque.repository.UsuarioRepository;

import java.time.LocalDateTime; // Adicione essa linha
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para buscar um usuário por ID
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        usuario.setCreatedAt(LocalDateTime.now());
        usuario.setUpdatedAt(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    // Método para atualizar um usuário existente
    @Transactional
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setUsername(usuarioAtualizado.getUsername());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    usuario.setNomeCompleto(usuarioAtualizado.getNomeCompleto());
                    usuario.setAtivo(usuarioAtualizado.getAtivo());
                    usuario.setUpdatedAt(LocalDateTime.now());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    // Método para deletar um usuário por ID
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}