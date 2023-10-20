package com.tarefa8.Fintech;

import com.tarefa8.Fintech.DTO.UserDTO;
import com.tarefa8.Fintech.Dao.UserDao;
import com.tarefa8.Fintech.model.User;
import org.springframework.boot.SpringApplication;

import java.sql.SQLException;
import java.util.List;

public class Tarefa8 {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(FintechApplication.class, args);
        UserDao userDao = new UserDao();

        UserDTO userDTO1 = new UserDTO("gabriel", "gabrielsartarelli@gmail.com", "123454");
        UserDTO userDTO2 = new UserDTO("lucas", "lucas@gmail.com", "123454");
        UserDTO userDTO3 = new UserDTO("athos", "athos@gmail.com", "12454");
        UserDTO userDTO4 = new UserDTO("vinicius", "vinicius@gmail.com", "125454");
        UserDTO userDTO5 = new UserDTO("joão", "joãozinho@gmail.com", "345454");


        userDao.criarUsuario(userDTO1);
        userDao.criarUsuario(userDTO2);
        userDao.criarUsuario(userDTO3);
        userDao.criarUsuario(userDTO4);
        userDao.criarUsuario(userDTO5);

        List<User> userList = userDao.listarUsuarios();

        for (User user : userList) {
            System.out.println(user.getName());
        }

    }

}
