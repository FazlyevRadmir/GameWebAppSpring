package com.fazlyev.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "message")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String userName;

    public MessageModel(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }
}
