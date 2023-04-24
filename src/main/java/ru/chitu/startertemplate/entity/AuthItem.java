package ru.chitu.startertemplate.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "auth_item")
public class AuthItem {
    @Id
    private String name;
    private int type;
    private String description;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "data")
    public byte[] data;
    @Column(name = "created_at")
    public LocalDate createdAt;
    @Column(name = "updated_at")
    public LocalDate updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
