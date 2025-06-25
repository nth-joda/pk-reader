package com.dacuni.library.content_service.service;
import java.util.List;

public interface ContentService <TDto>{
    TDto findById(Long id);
    List<TDto> findAll();
    TDto create(TDto dto);
    TDto update(Long id, TDto dto);
    void delete(Long id);
}
