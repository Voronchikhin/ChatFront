package ru.neofr.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ServerMessage {
    private String message;
    private Date sendTime;
    private String userName;
    private int id;
    private int userId;
}
