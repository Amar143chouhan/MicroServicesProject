package com.hotelserivce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel
{

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
