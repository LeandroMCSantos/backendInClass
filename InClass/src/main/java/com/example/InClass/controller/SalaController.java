package com.example.InClass.controller;
import com.example.InClass.model.Sala;
import com.example.InClass.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "https://localhost:3000")
@RestController

@RequestMapping("/salas")
public class SalaController  {
@Autowired
private SalaRepository salaRepository;
@GetMapping
public List<Sala> listarSalas() {
return salaRepository.findAll();
}
@PostMapping
public Sala criarSala (@RequestBody Sala sala) {
return salaRepository.save(sala);
}
}