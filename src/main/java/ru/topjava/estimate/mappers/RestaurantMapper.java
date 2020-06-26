package ru.topjava.estimate.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.to.UserRestaurantTo;

import java.util.stream.Collectors;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mappings({
            @Mapping(target = "price", source = "restaurantPrice", ignore = true),
            @Mapping(target = "voteCounter", ignore = true),
            @Mapping(target = "hasVoteToday", ignore = true)
    })
    UserRestaurantTo toDTO(Restaurant restaurant);
//
//    @AfterMapping
//    default void toRestaurantDTO(Restaurant restaurant, @MappingTarget RestaurantTo dto) {
//        dto.setPrice(
//                restaurant.getRestaurantPrice().stream()
//                .map(x -> new PriceTo(x.getId(), x.getDish(), x.getPrice()))
//                .collect(Collectors.toSet())
//        );
//        dto.setVoteCounter(restaurant.getVotes().size());
//    }
    @AfterMapping
    default void toRestaurantDTO(Restaurant restaurant, @MappingTarget UserRestaurantTo dto) {
        dto.setPrice(
                restaurant.getRestaurantPrice().stream()
                .map(PriceMapper.INSTANCE::toDTO)
                .collect(Collectors.toSet())
        );
        dto.setVoteCounter(restaurant.getVotes().size());
    }
}
