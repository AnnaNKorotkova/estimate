package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.RestaurantMapper;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.security.jwt.JwtUser;
import ru.topjava.estimate.service.PriceService;
import ru.topjava.estimate.service.RestaurantService;
import ru.topjava.estimate.service.UserService;
import ru.topjava.estimate.service.VoteService;
import ru.topjava.estimate.to.BaseTo;
import ru.topjava.estimate.to.UserRestaurantTo;
import ru.topjava.estimate.util.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = UserRestaurantController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantController {
    static final String URL = "/restaurants";

    @Value("${voting.end.time}")
    private String votingEndTime;

    private final RestaurantService restaurantService;
    private final VoteService voteService;
    private final PriceService priceService;
    private final UserService userService;

    public UserRestaurantController(RestaurantService restaurantService, VoteService voteService, PriceService priceService, UserService userService) {
        this.restaurantService = restaurantService;
        this.voteService = voteService;
        this.priceService = priceService;
        this.userService = userService;
    }

    @GetMapping
    public List<UserRestaurantTo> getAll(@AuthenticationPrincipal JwtUser authUser) {
        List<UserRestaurantTo> list = restaurantService.getAll()
                .stream()
                .map(x -> x.setAndGetInstance(x, Set.copyOf(priceService.findAllByDateAndRestaurant(LocalDate.now().minusDays(3), x)))) // TODO delete minus
                .map(RestaurantMapper.INSTANCE::toDTO)
                .map(x -> x.setAndGetInstance(x, hasVoteToday(x, authUser)))
                .collect(Collectors.toList());
        return list;
    }

//    @GetMapping
//    public List<RestaurantTo> getAllWithVotes() {
//        return restaurantService.getAllWithVotes()
//                .stream()
//                .map(RestaurantMapper.INSTANCE::toDTO)
//                .map(x -> x.setAndGet(x, hasVoteToday(x)))
//                .collect(Collectors.toList());
//    }

//    @GetMapping("/all")
//    public List<Restaurant> getAllPr() {
//        return restaurantService.getAllWithPriceAndVotes();
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setVote(@RequestBody BaseTo restaurant, @AuthenticationPrincipal JwtUser authUser) {
        if (LocalTime.now().isBefore(LocalTime.parse(votingEndTime))) {
            LocalDate today = LocalDate.now();
            User user = getFromJwtUser(authUser);
            Vote existing = voteService.findByUserAndDate(user, today);

            Long id = existing == null ? null : existing.getId();
            Vote created = voteService.save(new Vote(id, today, LocalTime.now(), user,
                    restaurantService.get(restaurant.getId())));
            return "You have voted: " + voteService.get(created.getId()) + " " + voteService.get(created.getId()).getTime();  //TODO remove unnecessary queries
        }
        return "Sorry, you can't vote after " + votingEndTime + " AM";
    }

    private boolean hasVoteToday(UserRestaurantTo restaurant, JwtUser authUser) {
        Vote vote = voteService.findByUserAndDate(getFromJwtUser(authUser), LocalDate.now());
        return vote != null && vote.getRestaurant().id() == restaurant.id();
    }

    private User getFromJwtUser(JwtUser authUser) {
        return userService.get(authUser.getId());
    }
}
