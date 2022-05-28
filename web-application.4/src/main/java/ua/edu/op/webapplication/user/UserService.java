package ua.edu.op.webapplication.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //Подключаем Bean - Autowiring
    private UserRepository userRepository;

    //Наш Bean будет внедрен через конструктор в UserService (Dependency Injection)
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Создаем метод, который будет обращаться к репозиторию
    public List<User> getAllUsers() {
        return userRepository.findAll();//Select * from
    }

    public void addUser(User user)
    {
        userRepository.saveAndFlush(user);//Добавляет пользователя в базу
    }


    /*public String addUser(@RequestBody User user) {
        User user1 = user;
        user1.setLogin(user.getLogin());
        user1.setMail(user.getMail());
        user1.setPassword(user.getPassword());
        user1.setPhone(user.getPhone());

        //Добавляем человека в БД
        //models.addA

        return "succes";
    }*/

}
