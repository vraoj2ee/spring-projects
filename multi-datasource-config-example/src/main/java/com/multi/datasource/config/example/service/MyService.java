package com.multi.datasource.config.example.service;

import com.multi.datasource.config.example.context.DataSourceContextHolder;
import com.multi.datasource.config.example.repository.PrimaryEntityRepository;
import com.multi.datasource.config.example.repository.SecondaryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final PrimaryEntityRepository primaryRepository;
    private final SecondaryEntityRepository secondaryRepository;

    @Autowired
    public MyService(PrimaryEntityRepository primaryRepository, SecondaryEntityRepository secondaryRepository) {
        this.primaryRepository = primaryRepository;
        this.secondaryRepository = secondaryRepository;
    }

    public void switchAndPerformOperation(boolean usePrimary) {
        if (usePrimary) {
            DataSourceContextHolder.setDataSourceType("primary");
            primaryRepository.findAll();
        } else {
            DataSourceContextHolder.setDataSourceType("secondary");
            secondaryRepository.findAll();
        }
    }
}
