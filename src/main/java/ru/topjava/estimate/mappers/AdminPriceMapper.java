package ru.topjava.estimate.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.to.AdminPriceTo;
import ru.topjava.estimate.to.UserPriceTo;

@Mapper
public interface AdminPriceMapper {

        AdminPriceMapper INSTANCE = Mappers.getMapper(AdminPriceMapper.class);
        @Mappings({
                @Mapping(target = "date", source = "date"),
                @Mapping(target = "restaurant", source = "restaurant"),
                @Mapping(target = "dish", source = "dish"),
                @Mapping(target = "price", source = "price")
        })
        AdminPriceTo toDTO(Price price);

        @Mappings({
                @Mapping(target = "date", source = "date"),
                @Mapping(target = "restaurant", source = "restaurant"),
                @Mapping(target = "dish", source = "dish"),
                @Mapping(target = "price", source = "price")
        })
        Price fromDTO(AdminPriceTo price);
}
