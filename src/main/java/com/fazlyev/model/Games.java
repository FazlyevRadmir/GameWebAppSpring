package com.fazlyev.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "game")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Games{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "game_name")
    private String gameName;

}
