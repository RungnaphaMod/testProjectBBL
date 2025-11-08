package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
}


