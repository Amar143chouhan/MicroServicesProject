package com.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User
{

    @Id
    private  String userid;
    private String username;
    private String email;
    private  String about;
    @Transient
    private List<Rating> list =new ArrayList<>();


}
