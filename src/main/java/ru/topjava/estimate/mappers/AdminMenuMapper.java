package ru.topjava.estimate.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.to.AdminMenuTo;

@Mapper
public interface AdminMenuMapper {

        AdminMenuMapper INSTANCE = Mappers.getMapper(AdminMenuMapper.class);

        AdminMenuTo toDTO(MenuItem menuItem);

        MenuItem fromDTO(AdminMenuTo menuTo);
}
