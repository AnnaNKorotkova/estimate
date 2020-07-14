package ru.topjava.estimate.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.to.UserMenuItemTo;

@Mapper
public interface UserPriceMapper {

        UserPriceMapper INSTANCE = Mappers.getMapper(UserPriceMapper.class);

        @Mappings({
                @Mapping(target = "date", dateFormat = "dd-MM-yyyy"),
                @Mapping(target = "dishName", ignore = true),
                @Mapping(target = "dishPrice", ignore = true)
        })
        UserMenuItemTo toDTO(MenuItem price);

        @AfterMapping
        default void toPriceDTO(MenuItem price, @MappingTarget UserMenuItemTo dto) {
                dto.setDate(price.getDate());
                dto.setDishName(price.getDish().getName());
                dto.setDishPrice(price.getPrice());
        }
}
