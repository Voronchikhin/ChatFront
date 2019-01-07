package ru.neofr.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginReply {
    private int id;
    private String token;
    private boolean online;
    private String username;
}
