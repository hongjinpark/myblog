package com.example.myblog.domain.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password; //비밀번호

    @Column(nullable = false, length = 50)
    private String email; //이메일

    @Column(nullable = false, length = 20)
    private String nickname; //닉네임

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
