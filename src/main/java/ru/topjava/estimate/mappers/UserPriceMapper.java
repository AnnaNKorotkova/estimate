package ru.topjava.estimate.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.to.UserPriceTo;

@Mapper
public interface UserPriceMapper {

        UserPriceMapper INSTANCE = Mappers.getMapper(UserPriceMapper.class);

        @Mappings({
                @Mapping(target = "date", dateFormat = "dd-MM-yyyy"),
                @Mapping(target = "dishName", ignore = true),
                @Mapping(target = "dishPrice", ignore = true)
        })
        UserPriceTo toDTO(Price price);

        @AfterMapping
        default void toPriceDTO(Price price, @MappingTarget UserPriceTo dto) {
                dto.setDate(price.getDate());
                dto.setDishName(price.getDish().getName());
                dto.setDishPrice(price.getPrice());
        }
}
