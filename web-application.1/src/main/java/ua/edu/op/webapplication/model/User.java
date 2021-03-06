package ua.edu.op.webapplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_info")//Если name = "user" , то выдает ошибку
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;

    @Column(nullable = false)
    private String login;

    private String mail;

    @Column(nullable = false)
    private String password;

    private String phone;
}
