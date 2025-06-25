package com.dacuni.library.content_service.repository;

import com.dacuni.library.content_service.entity.NovelEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<NovelEnt, Long> {
}
