package ua.edu.op.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.edu.op.webapplication.User_problem;
import ua.edu.op.webapplication.model.User;
import ua.edu.op.webapplication.services.UserService;

import java.util.List;
import java.util.Set;


@RestController
public class DefaultController {

    private final UserService service;

    @Autowired
    public DefaultController(UserService service) {
        this.service = service;
    }

/*
        @GetMapping("/user")
        public ResponseEntity<?> getUserById(@RequestParam(value = "id") long userId) {
            if (userId < 0) {
                return ResponseEntity.badRequest().body("User id have to be positive");
            }
            else
            {
                return ResponseEntity.ok().body(new User(4, "Daniil", "lala@gmail.com", "dska;kdsa21", "0503988822"));
            }
        }//Моделируем ответ от базы, в реальном приложении мы бы полезли в базу данных.
*/

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();//Возвращаем пользователей
    }

  @PostMapping("/user/register")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }



 /*       //http://localhost:8080/test?building=5&room=2
        @GetMapping(value = "/test")
        public String foo(
                @RequestParam(value = "building") int buildingId,
                @RequestParam(value = "room") int roomId) {
            return "Information about building " + buildingId +
                    "\nInformation about room " + roomId;
        }*/


    //http://localhost:8080/register?userId&login&password&phone
    //@PostMapping(value = "/register")

/*    public void register(
            @RequestParam(value = "userId") int userId,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "phone") String phone) {
        System.out.println(" " + userId + " " + login + " " + password + " " + phone);
    }*/

}
