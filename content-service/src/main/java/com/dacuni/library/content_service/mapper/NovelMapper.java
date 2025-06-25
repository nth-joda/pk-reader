package com.dacuni.library.content_service.mapper;

import com.dacuni.library.content_service.dto.NovelDto;
import com.dacuni.library.content_service.entity.NovelEnt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NovelMapper {
    NovelDto toDto(NovelEnt entity);
    NovelEnt toEntity(NovelDto dto);
}
