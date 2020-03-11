package br.com.rd.ecom.user;

import br.com.rd.ecom.repository.UserRepository;
import br.com.rd.ecom.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-user")
    public User save (@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/find-users/list")
    public List<User> find() {return userRepository.findAll();}
}