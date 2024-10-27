package com.multi.datasource.config.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multi.datasource.config.example.entity.secondary.SecondaryEntity;

public interface SecondaryEntityRepository extends JpaRepository<SecondaryEntity, Long> {
}
