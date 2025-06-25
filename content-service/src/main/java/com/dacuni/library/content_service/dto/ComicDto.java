package com.dacuni.library.content_service.dto;

public record ComicDto(
        Long id,
        String title,
        String author,
        String synopsis,
        String status
) {
}
