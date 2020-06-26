package ru.topjava.estimate.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.RestaurantMapper;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.service.PriceService;
import ru.topjava.estimate.service.RestaurantService;
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

    static LocalTime END_TIME_VOTING = LocalTime.parse("11:00:00");

    private final RestaurantService restaurantService;
    private final VoteService voteService;
    private final PriceService priceService;

    public UserRestaurantController(RestaurantService restaurantService, VoteService voteService, PriceService priceService) {
        this.restaurantService = restaurantService;
        this.voteService = voteService;
        this.priceService = priceService;
    }

    @GetMapping
    public List<UserRestaurantTo> getAll() {
        return restaurantService.getAll()
                .stream()
                .map(x -> x.setAndGetInstance(x, Set.copyOf(priceService.findAllByDateAndRestaurant(LocalDate.now(), x))))
                .map(RestaurantMapper.INSTANCE::toDTO)
                .map(x -> x.setAndGetInstance(x, hasVoteToday(x)))
                .collect(Collectors.toList());
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
    public String setVote(@RequestBody BaseTo restaurant) {
        if (LocalTime.now().isBefore(END_TIME_VOTING)) {
            LocalDate today = LocalDate.now();
            User authUser = SecurityUtil.getAuthorizedUser();
            Vote existing = voteService.findByUserAndDate(authUser, today);

            Long id = existing == null ? null : existing.getId();
            voteService.save(new Vote(id, LocalDate.now(), LocalTime.now(), SecurityUtil.getAuthorizedUser(),
                    restaurantService.get(restaurant.getId())));
            return "You have voted" + voteService.get(existing.getId()).toString() + " " + voteService.get(existing.getId()).getTime().toString();
        }
        return "Sorry, you can't vote after 11:00 AM";
    }

    private boolean hasVoteToday(UserRestaurantTo restaurant) {
        Vote vote = voteService.findByUserAndDate(SecurityUtil.getAuthorizedUser(), LocalDate.now());
        return vote != null && vote.getRestaurant().id() == restaurant.id();
    }
}
