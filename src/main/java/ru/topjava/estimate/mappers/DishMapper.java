package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.to.DishTo;

@Mapper
public interface DishMapper {

    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    DishTo toDTO(Dish dish);

}
