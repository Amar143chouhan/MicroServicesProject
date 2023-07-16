package com.userservice.service;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exception.ResourcenotFoundException;
import com.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private HotalService  hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserid(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userid)
    {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userid).orElseThrow(()
                -> new ResourcenotFoundException("User with given id is not found on server !! : " + userid));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad

      Rating[] list = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserid(), Rating[].class);


        //Rating[] ratingsofuser =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Rating[].class);

        List<Rating> ratings = Arrays.stream(list).collect(Collectors.toList());

        logger.info("{} ", ratings);


        for (Rating r:ratings)
        {

            var hotelid = r.getHotelid();

            var replace = hotelid.replace("'", " ");


            System.out.println(replace);
        }

        // List<Rating> ratings = Arrays.stream(ratingsofuser).collect(Collectors.toList());


        var ratingList = ratings.stream().map(rating ->

        {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
            var hotel = restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelid().replace("'"," "), Hotel.class).getBody();

            logger.info("{}", hotel);

            System.out.println(rating.getHotelid());


            //logger.info("{}",forEntity);

            // Hotel hotel = (Hotel) forEntity.getBody();
            //List<Hotel> hotel = Arrays.stream(forEntity).collect(Collectors.toList());

            //    logger.info("{}",hotel);

            // Hotel hotel = hotelService.getHotel(rating.getHotelid());
            //logger.info("response status code: {} ",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;

        }).collect(Collectors.toList());

        //     user.setList(ratings);

        user.setList(ratingList);

        return user;
    }



}
