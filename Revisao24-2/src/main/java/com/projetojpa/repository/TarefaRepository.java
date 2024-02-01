package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

}
