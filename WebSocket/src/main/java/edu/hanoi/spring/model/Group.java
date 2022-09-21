package edu.hanoi.spring.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "hn_group",uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "group")
    private List<User> users;
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Group(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
