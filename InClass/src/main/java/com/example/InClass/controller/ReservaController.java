package com.example.InClass.controller;
import com.example.InClass.model.Reserva;
import com.example.InClass.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarReserva(@PathVariable Integer id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.ok("Reserva deletada com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Integer id, @RequestBody Reserva reservaAtualizada) {
        if (reservaRepository.existsById(id)) {
            Reserva reserva = reservaRepository.findById(id).get();
            reserva.setId_reserva(reservaAtualizada.getId_reserva());
            reserva.setData_hora(reservaAtualizada.getData_hora());
            reserva.setTipo(reservaAtualizada.getTipo());
            reserva.setObservacao(reservaAtualizada.getObservacao());

            Reserva reservaAtualizadaBD = reservaRepository.save(reserva);
            return ResponseEntity.ok(reservaAtualizadaBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
