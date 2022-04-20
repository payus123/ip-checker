package com.vero.ipchecker.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_checker")
@Data
public class UserChecker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ipAddress;


}
