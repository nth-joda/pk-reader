package com.dacuni.library.content_service.controller;

import com.dacuni.library.content_service.dto.ComicDto;
import com.dacuni.library.content_service.exception.ResourceNotFoundException;
import com.dacuni.library.content_service.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comics")
public class ComicController {
    private final ContentService<ComicDto> contentService;
    public ComicController(ContentService<ComicDto> contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ComicDto>> get(){
        return ResponseEntity.ok(contentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComicDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(contentService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<ComicDto> create(@RequestBody ComicDto dto) {
        return ResponseEntity.ok(contentService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComicDto> update(@PathVariable Long id, @RequestBody ComicDto dto) {
        return ResponseEntity.ok(contentService.update(id, dto));
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
