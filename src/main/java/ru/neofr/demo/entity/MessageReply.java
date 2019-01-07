package ru.neofr.demo.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MessageReply {
    private List<ServerMessage> messages;
}
