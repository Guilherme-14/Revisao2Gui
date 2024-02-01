package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Tarefa;
import com.projetojpa.repository.TarefaRepository;

@Service
public class TarefaService {
	
private final TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	
	public List<Tarefa> buscaTodosTarefa(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa BuscaTarefaId(Long id) {
		Optional <Tarefa> Tarefa = tarefaRepository.findById(id);
		return Tarefa.orElse(null);
	}
	
	public Tarefa salvaTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);	
	}
	
	public Tarefa alterarTarefa (Long id, Tarefa alterarT) {
		Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			alterarT.setId(id);
			return tarefaRepository.save(alterarT);
		}
		return null;
	}
	
	public boolean apagarTarefa(Long id) {
		Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
