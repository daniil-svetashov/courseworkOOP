package ua.edu.op.webapplication.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Есть интерфейс JpaRepository , в нем определены какие-то методы и мы от него наследуемся и можем объявить свои методы
//Для каждой сущности есть свой интерфейс репозитория, данный репо будет работать с сущностью User
//Второй параметр это тип id в бд
public interface UserRepository extends JpaRepository <User,Long> {
    //методы для доступа к базе
}
