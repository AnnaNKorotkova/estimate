
package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.to.NamedTo;

@Mapper
public interface NamedMapper {

    NamedMapper INSTANCE = Mappers.getMapper(NamedMapper.class);

    NamedTo toDTO(Restaurant restaurant);
    NamedTo toDTO(Vote restaurant);
    NamedTo toDTO(Price restaurant);
}