package ru.neofr.demo.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
/**
* используеться для отображения во фронте
*
* */
public class Message {
    private String payload = "payload_";
    private String author = "author_";
    private String date = "date_";
}
