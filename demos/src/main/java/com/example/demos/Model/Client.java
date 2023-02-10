package com.example.demos.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Client {

    @Id
    private long id;
}
