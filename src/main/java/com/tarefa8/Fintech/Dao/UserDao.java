package com.tarefa8.Fintech.Dao;

import com.tarefa8.Fintech.DTO.UserDTO;
import com.tarefa8.Fintech.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {


    private Connection connection;

    public UserDao() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String DATABASE_URL = "jdbc:mysql://localhost:3306/tarefa8?createDatabaseIfNotExist=true";
            String user = "root";
            String password = "admin";
            this.connection = DriverManager.getConnection(DATABASE_URL, user, password);
        } catch (ClassNotFoundException | SQLException exception) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public List<User> listarUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        List<User> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                User user = new User();
                user.setName(resultado.getString("name"));
                user.setEmail(resultado.getString("email"));
                user.setPassword(resultado.getString("password"));
                retorno.add(user);
            }
        } catch (SQLException exception) {
            throw new SQLException("problema no db");
        }
        return retorno;
    }


    public User criarUsuario(UserDTO userDTO) throws SQLException {
        String sql = "INSERT INTO usuarios(name,email,password) VALUES(?,?,?)";
        User user;
        try {
            user = new User(userDTO);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.execute();
            System.out.println("usuario criado com sucesso!");


        } catch (SQLException exception) {
            throw new SQLException("problema no db");
        }
        return user;
    }
}
