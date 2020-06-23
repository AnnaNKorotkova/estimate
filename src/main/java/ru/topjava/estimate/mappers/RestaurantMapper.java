package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.to.RestaurantTo;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);


    RestaurantTo toDTO(Restaurant restaurant);
}
