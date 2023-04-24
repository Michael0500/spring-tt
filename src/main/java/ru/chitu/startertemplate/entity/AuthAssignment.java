package ru.chitu.startertemplate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "auth_assignment") // т.к. у нас составной первичный ключ
@IdClass(UserItemName.class)
public class AuthAssignment {
    @Id
    public String item_name;
    @Id
    public String user_id;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}

class UserItemName implements Serializable {
    private final String item_name;
    private final int user_id;

    public UserItemName(String item_name, int user_id) {
        this.item_name = item_name;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserItemName that = (UserItemName) o;
        return Objects.equals(item_name, that.item_name) && Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_name, user_id);
    }
}