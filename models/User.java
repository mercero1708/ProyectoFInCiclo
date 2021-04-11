package com.disenotuweb.segurizarAplicacion.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email"),        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    public long date;

    @NotBlank
    @Size(max = 20)
    private String username;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)//**Un usuario puede tener varios roles y un rolo puede pertenecer varios usados**/
    // tabla intermedia para relacionar que va a conectar el id del usu con el id del rol, para relacionarlos
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),// hace referencia al campo
            inverseJoinColumns = @JoinColumn(name = "role_id"))// hace referencia al campo
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username,String email, String password ) {
        this.username = username;
        this.email = email;
        this.password = password;

    }
    //getter and setter para la fecha

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
