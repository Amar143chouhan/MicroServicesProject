package com.ratingService.entities;
import com.userservice.entities.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document("user_rating")
    public class Rating
    {   @Id
        private String ratingid;
        private String userid;
        private String hotelid;
        private int   rating;
        private String feedback ;
        private  Hotel hotel;
    }
