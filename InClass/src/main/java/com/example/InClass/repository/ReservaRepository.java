package com.example.InClass.repository;


import com.example.InClass.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
