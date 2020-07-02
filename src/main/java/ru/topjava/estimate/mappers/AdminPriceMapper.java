package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.to.AdminPriceTo;

@Mapper
public interface AdminPriceMapper {

        AdminPriceMapper INSTANCE = Mappers.getMapper(AdminPriceMapper.class);

        AdminPriceTo toDTO(Price price);

        Price fromDTO(AdminPriceTo priceTo);
}
