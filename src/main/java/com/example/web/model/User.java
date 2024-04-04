package com.example.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId userid;
    private String firstname;
    private String lastname;
    private int age;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
    private byte[] profile;
}
