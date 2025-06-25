package com.dacuni.library.content_service.service.impl;

import com.dacuni.library.content_service.dto.ComicDto;
import com.dacuni.library.content_service.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ContentService<ComicDto> {

    @Override
    public ComicDto findById(Long id) {
        return null;
    }

    @Override
    public List<ComicDto> findAll() {
        return List.of();
    }

    @Override
    public ComicDto create(ComicDto comicDto) {
        return null;
    }

    @Override
    public ComicDto update(Long id, ComicDto comicDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
