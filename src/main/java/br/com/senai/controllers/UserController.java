package br.com.senai.controllers;

import br.com.senai.models.Users;
import br.com.senai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
import static br.com.senai.repositories.UsersRepository.*;

=======
>>>>>>> github/master
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    @PostMapping(value="/createUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users createUsers(@RequestBody Users users){
        Users newUsers = new Users();
<<<<<<< HEAD
        newUsers.setUsername(users.getUsername());
        newUsers.setPassword(users.getPassword());
=======
        newUsers.setName(users.getName());
        newUsers.setPrice(users.getPrice());
>>>>>>> github/master
        return usersRepository.save(newUsers);
    }
    @PutMapping(value="/updateUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users updateUsers(@RequestBody Users users){
<<<<<<< HEAD
        Users getUsers = usersRepository.findById(users.getId()).orElseThrow();
        Users updateUsers = new Users();

        updateUsers.setId(users.getId());
        updateUsers.setUsername(users.getUsername());
        updateUsers.setPassword(users.getPassword());

        return  usersRepository.save(updateUsers);
    }
    @DeleteMapping(value="/deleteUsers/{id}",
=======
        Users getUsers = UsersRepository.findById(users.getId()).orElseThrow();
        Users updateUsers = new Users();

        updateUsers.setId(users.getId());
        updateUsers.setName(users.getName());
        updateUsers.setPrice(users.getPrice());

        return  usersRepository.save(updateUsers);
    }
    @DeleteMapping(value="/deleteUser/{id}",
>>>>>>> github/master
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  Users deleteUsers(@PathVariable Long id){
        Users getUsers = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(getUsers);
        return  getUsers;
    }
}
