package com.hashmap.assessment.model;

import com.hashmap.assessment.model.Role;
import com.hashmap.assessment.model.Type;
import lombok.Getter;

@Getter
public class Info {
    private String name;
    private String email;
    private Type type;
    private Role role;

    public void setType(Type type) {
        this.type = type;
    }

    public Info(String name, String email, Type type, Role role) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.role = role;
    }
}
