package com.example.InClass.controller;
import com.example.InClass.model.Usuario;
import com.example.InClass.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "https://localhost:3000")
@RestController

@RequestMapping("/usuario")
public class UsuarioController  {
@Autowired
private UsuarioRepository usuarioRepository;
@GetMapping
public List<Usuario> listarUsuarios() {
return usuarioRepository.findAll();
}
@PostMapping
public Usuario criarUsuario (@RequestBody Usuario usuario) {
return usuarioRepository.save(usuario);
}
}