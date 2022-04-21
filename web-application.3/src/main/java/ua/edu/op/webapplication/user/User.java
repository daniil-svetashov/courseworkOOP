package ua.edu.op.webapplication.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_info")//Если name = "user" , то выдает ошибку
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//или SEQUENCE
    private long userId;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    public User(long userId, String login, String name, String surname, String mail, String password) {
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public User() { //пустой конструктор, нужен
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
