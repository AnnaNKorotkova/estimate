package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.to.DishTo;
import ru.topjava.estimate.to.PriceTo;

@Mapper
public interface PriceMapper {

        PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

        PriceTo toDTO(Price price);

}
