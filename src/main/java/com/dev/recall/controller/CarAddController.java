package com.dev.recall.controller;

import com.dev.recall.dto.CarRequestAddDto;
import com.dev.recall.mapper.CarMapper;
import com.dev.recall.service.CarService;
import com.dev.recall.service.impl.CarServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarAddController {
    private final CarService carService = new CarServiceImpl();

    @PostMapping
    public void addMovie(@RequestBody CarRequestAddDto movieRequestAddDto) {
        carService.save(CarMapper.map(movieRequestAddDto));
    }
}
