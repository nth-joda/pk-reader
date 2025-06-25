package com.dacuni.library.content_service.repository;

import com.dacuni.library.content_service.entity.NovelEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<NovelEnt, Long> {
}
