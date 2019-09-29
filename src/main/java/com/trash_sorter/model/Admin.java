package com.trash_sorter.model;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name ="name")
    private String name;

    @Column(name = "password")
    private String password;

    public Admin(){}
    public Admin(String login, String password) {
        this.name = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String login) {
        this.name = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Admin admin = (Admin) obj;
        if (id != admin.id) return false;
        if (name != admin.name) return false;
        return password.equals(admin.password);
    }
}
