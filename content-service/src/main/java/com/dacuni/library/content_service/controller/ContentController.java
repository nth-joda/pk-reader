package com.dacuni.library.content_service.controller;

import com.dacuni.library.content_service.dto.NovelDto;
import com.dacuni.library.content_service.exception.ResourceNotFoundException;
import com.dacuni.library.content_service.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/novels")
public class ContentController {
    private final ContentService<NovelDto> contentService;
    public ContentController(ContentService<NovelDto> contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<NovelDto>> get(){
        return ResponseEntity.ok(contentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NovelDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(contentService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<NovelDto> create(@RequestBody NovelDto novelDto) {
        return ResponseEntity.ok(contentService.create(novelDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NovelDto> update(@PathVariable Long id, @RequestBody NovelDto novelDto) {
        return ResponseEntity.ok(contentService.update(id, novelDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        contentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        return new ResponseEntity<ErrorResponse>(HttpStatus.NOT_FOUND);
    }

}
