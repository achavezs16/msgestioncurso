package com.altias.mic_autenticacion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;

import com.altias.mic_autenticacion.repository.UserRepository;
import com.altias.mic_autenticacion.usuario.User;

// @RestController
// public class Control {
//     private final UserRepository userRepository;

//     public Control(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
// }
@RestController
@RequestMapping("/api/v1/users")//http://localhost:8080/api/v1/users (ruta para POSTMAN)
//SELECT * FROM bd_usuario.user;(en la base de datos bd_usuario)
public class Control {

    @Autowired
    private UserRepository userRepository;

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
        //return user.getNombre()+" "+user.getEmail();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/usuarioPorId")
    //http://localhost:8080/api/v1/users/usuarioPorId?id=1
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            //retorna solo email y nombre
            User userResponse = new User();
            userResponse.setNombre(user.getNombre());
            userResponse.setEmail(user.getEmail());
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
