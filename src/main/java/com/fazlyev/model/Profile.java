package com.fazlyev.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Profile(String city) {
        this.city = city;
        this.user = new User();
        this.user.setProfile(this);
    }
}
