package br.com.senai.controllers;

import br.com.senai.models.Users;
import br.com.senai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        newUsers.setName(users.getName());
        newUsers.setPrice(users.getPrice());
        return usersRepository.save(newUsers);
    }
    @PutMapping(value="/updateUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users updateUsers(@RequestBody Users users){
        Users getUsers = UsersRepository.findById(users.getId()).orElseThrow();
        Users updateUsers = new Users();

        updateUsers.setId(users.getId());
        updateUsers.setName(users.getName());
        updateUsers.setPrice(users.getPrice());

        return  usersRepository.save(updateUsers);
    }
    @DeleteMapping(value="/deleteUser/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  Users deleteUsers(@PathVariable Long id){
        Users getUsers = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(getUsers);
        return  getUsers;
    }
}
