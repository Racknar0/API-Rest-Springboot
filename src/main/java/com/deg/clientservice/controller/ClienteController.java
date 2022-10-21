package com.deg.clientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deg.clientservice.model.ClienteModel;
import com.deg.clientservice.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
    

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll() {
        return new ResponseEntity<>(this.clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> findById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(this.clienteService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> createClient(@RequestBody ClienteModel cliente){
        System.out.println("************************************************************: ");
        System.out.println(cliente);
        return new ResponseEntity<>(this.clienteService.createClient(cliente), HttpStatus.CREATED);
    }

}
