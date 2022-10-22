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
    public ResponseEntity<?> createClient(@RequestBody ClienteModel cliente) {
        System.out.println("************************************************************: ");
        System.out.println(cliente);

        if (cliente.getNombre() == null || cliente.getApellido() == null || cliente.getFecha_nacimiento() == null) {
            return ResponseEntity.badRequest()
                    .body("Los campos nombre, apellido y fecha de nacimiento son obligatorios");
        }

        if (cliente.getNombre().length() < 3 || cliente.getApellido().length() < 3) {
            return ResponseEntity.badRequest().body("Los campos nombre y apellido deben tener al menos 3 caracteres");
        }

        try {
            System.out.println("************************************************************: ");
           /* añadir la edad al objeto devuelto */
           System.out.println(clienteService.calcularEdad(cliente.getFecha_nacimiento()));

          /*  cliente.setFecha_nacimiento(clienteService.calcularEdad(cliente.getFecha_nacimiento())); */



            return new ResponseEntity<>(this.clienteService.createClient(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
