package br.gama.itau.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.validation.dto.UserAppDTO;
import br.gama.itau.validation.service.UserAppService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/user")
@Validated
public class UserAppController {
    
    @Autowired
    private UserAppService service;

    @PostMapping
    public ResponseEntity<UserAppDTO> createUser(@Valid @RequestBody UserAppDTO userAppDTO) {

        UserAppDTO userAppDTOCreated = service.createUser(userAppDTO);
        
        return ResponseEntity.ok(userAppDTOCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> validInput(@PathVariable @Min(5) long id) {
        return ResponseEntity.ok("valor valido");
    }
}
