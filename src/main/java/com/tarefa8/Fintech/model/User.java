package com.tarefa8.Fintech.model;

import com.tarefa8.Fintech.DTO.UserDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "User")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(UserDTO userDTO) {

        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }


}
