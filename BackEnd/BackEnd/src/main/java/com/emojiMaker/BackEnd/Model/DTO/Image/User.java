package com.emojiMaker.BackEnd.Model.DTO.Image;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter @Getter
@Table(name = "users")
public class User {

    @Id
    private long id;
    @Column(nullable = true, length = 64)
    private String photos;
}
