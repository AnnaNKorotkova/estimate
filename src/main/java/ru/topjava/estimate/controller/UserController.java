package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.RestaurantMapper;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.security.jwt.JwtUser;
import ru.topjava.estimate.service.RestaurantService;
import ru.topjava.estimate.service.UserService;
import ru.topjava.estimate.service.VoteService;
import ru.topjava.estimate.to.BaseTo;
import ru.topjava.estimate.to.UserRestaurantTo;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Value("${voting.end.time}")
    private String votingEndTime;

    private final RestaurantService restaurantService;
    private final VoteService voteService;
    private final UserService userService;

    public UserController(RestaurantService restaurantService, VoteService voteService, UserService userService) {
        this.restaurantService = restaurantService;
        this.voteService = voteService;
        this.userService = userService;
    }

    @GetMapping("/restaurants")
    public List<UserRestaurantTo> getAll(@AuthenticationPrincipal JwtUser authUser) {

        return restaurantService.getAllByToday()
                .stream()
                .map(RestaurantMapper.INSTANCE::toDTO)
                .map(x -> x.setAndGetInstance(x, hasVoteToday(x, authUser)))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setVote(@RequestBody @Valid BaseTo restaurant, @AuthenticationPrincipal @Valid JwtUser authUser) {
        User user = getFromJwtUser(authUser);
        return voteService.vote(restaurant.getId(),user,votingEndTime);
    }

    private boolean hasVoteToday(UserRestaurantTo restaurant, JwtUser authUser) {
        Vote vote = voteService.findByUserAndDate(getFromJwtUser(authUser), LocalDate.now());
        return vote != null && vote.getRestaurant().id() == restaurant.id();
    }

    private User getFromJwtUser(JwtUser authUser) {
        return userService.get(authUser.getId());
    }
}
