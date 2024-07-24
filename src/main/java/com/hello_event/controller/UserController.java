package com.hello_event.controller;


import com.hello_event.enums.Role;
import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.User;
import com.hello_event.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;


    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            var users = userService.getAll();
            return ResponseEntity.ok(users);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            var user = userService.getById(Long.valueOf(id));
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody User user) {
        var savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User userDto) {
        try {
            var updatedUser = userService.update(userDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        try {
            var deletedUser = userService.delete(Long.valueOf(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedUser);
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
