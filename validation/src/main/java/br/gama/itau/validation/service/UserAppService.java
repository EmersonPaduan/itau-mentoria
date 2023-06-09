package br.gama.itau.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.gama.itau.validation.dto.UserAppDTO;
import br.gama.itau.validation.model.UserApp;
import br.gama.itau.validation.repository.UserAppRepository;
import jakarta.validation.Valid;

@Service
@Validated
public class UserAppService {
    @Autowired
    private UserAppRepository repo;
    
    public UserAppDTO createUser(@Valid UserAppDTO userAppDTO) {
        UserApp userApp = new UserApp(userAppDTO);

        UserApp userCreated = repo.save(userApp);

        UserAppDTO userAppDTOCreated = new UserAppDTO(userCreated);
        return userAppDTOCreated;
    }

}
