package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.to.NameTo;

@Mapper
public interface NameMapper {

    NameMapper INSTANCE = Mappers.getMapper(NameMapper.class);

    NameTo toDTO(Restaurant restaurant);
}
