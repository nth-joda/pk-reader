package com.dacuni.library.content_service.service.impl;

import com.dacuni.library.content_service.dto.NovelDto;
import com.dacuni.library.content_service.entity.NovelEnt;
import com.dacuni.library.content_service.exception.ResourceNotFoundException;
import com.dacuni.library.content_service.mapper.NovelMapper;
import com.dacuni.library.content_service.repository.NovelRepository;
import com.dacuni.library.content_service.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService<NovelDto> {

    private final NovelRepository novelRepository;
    private final NovelMapper novelMapper;

    public ContentServiceImpl(NovelRepository novelRepository, NovelMapper novelMapper) {
        this.novelRepository = novelRepository;
        this.novelMapper = novelMapper;
    }

    @Override
    public NovelDto findById(Long id) {
        NovelEnt novelEnt = novelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Novel with id %s not found.", id)));
        return novelMapper.toDto(novelEnt);
    }

    @Override
    public List<NovelDto> findAll() {
        List<NovelEnt> novelEnts = novelRepository.findAll();
        List<NovelDto> res = new ArrayList<>();
        for (NovelEnt novelEnt : novelEnts) {
            res.add(novelMapper.toDto(novelEnt));
        }
        return res;
    }

    @Override
    public NovelDto create(NovelDto dto){
        if (dto == null) throw new ArithmeticException("Cannot create with null or empty novel");
        NovelEnt novelEnt = novelMapper.toEntity(dto);
        novelEnt.setId(null);
        novelEnt = novelRepository.save(novelEnt);
        return novelMapper.toDto(novelEnt);
    }

    @Override
    public NovelDto update(Long id, NovelDto dto) {
        if(dto == null) throw new ArithmeticException("Cannot create with null or empty novel");
        NovelEnt novelEnt = novelRepository.findById(dto.id()).orElseThrow(() -> new ResourceNotFoundException(String.format("Novel with id %s not found.", dto.id())));
        novelEnt.setTitle(!dto.title().isEmpty() ? dto.title() : novelEnt.getTitle());
        novelEnt.setAuthor(!dto.author().isEmpty() ? dto.author() : novelEnt.getAuthor());
        novelEnt.setSynopsis(!dto.synopsis().isEmpty() ? dto.synopsis() : novelEnt.getSynopsis());
        novelEnt.setStatus(!dto.status().isEmpty() ? dto.status() : novelEnt.getStatus());
        novelEnt = novelRepository.save(novelEnt);
        return novelMapper.toDto(novelEnt);
    }

    @Override
    public void delete(Long id) {
        NovelEnt novelEnt = novelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Novel with id %s not found.", id)));
        novelEnt.setDeleted(true);
        novelRepository.save(novelEnt);
    }
}
