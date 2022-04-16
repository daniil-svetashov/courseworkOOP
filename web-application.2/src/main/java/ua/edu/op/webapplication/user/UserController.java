package ua.edu.op.webapplication.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();//Возвращаем пользователей
    }


    //http://localhost:8080/?name=ASd
 /*   @GetMapping("/")
    public String hello(@RequestParam("name") String name,
    Model model){
        Date date = new Date(System.currentTimeMillis());

        //Объект модели, model это специальный класс, который позволяет нам запихнуть в него различные данные для того чтобы потом его передать в движок шаблонов.
        //Объект этого model нам передает Диспетчер Сервлет
        //Бизнес-логика


        return "registration";
    }*/

    @PostMapping("/registration")
    public String processForm(User user)
    {
        //к нам придет объект студента, json
        //из него будет сгенеринован объект студента
        service.addUser(user);
        return "redirect:/registration";
    }

    @GetMapping("/registration")
    public String addStudent(Model model){

        //Когда мы будем переходить на страницу формы, мы должны создать пустой объект пользователя и передать его в View register

        model.addAttribute("new_user", new User());
        return "registration";
    }




    //1. получить от сервиса список студентов
    //2. добавить список в model
    //3. вернуть название html файла

}
