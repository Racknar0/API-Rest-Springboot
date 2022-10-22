package com.deg.clientservice.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deg.clientservice.model.ClienteModel;
import com.deg.clientservice.repository.ClienteRepository;



@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }
    
    public ClienteModel findById(Integer id){
        return clienteRepository.findById(id).get();
    }

    public ClienteModel createClient(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public Integer calcularEdad(LocalDate fecha_nacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fecha_nacimiento, fechaActual);
        return periodo.getYears();
    }
    
    
}
