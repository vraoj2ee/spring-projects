package com.multi.datasource.config.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multi.datasource.config.example.entity.primary.PrimaryEntity;

public interface PrimaryEntityRepository extends JpaRepository<PrimaryEntity, Long> {
}
