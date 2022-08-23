package com.example.vegan_life.service;

import com.example.vegan_life.dto.CreateRequestDietDto;
import com.example.vegan_life.entity.Diet;
import com.example.vegan_life.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DietService {
    private final DietRepository dietRepository;
    public CreateRequestDietDto save(CreateRequestDietDto dto) {
        Diet entity = dto.toEntity();
        dietRepository.save(entity);
        return dto;
    }
}
