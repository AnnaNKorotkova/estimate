package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.to.NamedTo;

@Mapper
public interface NamedMapper {

    NamedMapper INSTANCE = Mappers.getMapper(NamedMapper.class);

    NamedTo toRestaurantTo(Restaurant restaurant);
    NamedTo toDishTo(Dish dish);
}