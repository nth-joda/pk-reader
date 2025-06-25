package com.dacuni.library.content_service.dto;

public record NovelDto(
        Long id,
        String title,
        String author,
        String synopsis,
        String status
) {}