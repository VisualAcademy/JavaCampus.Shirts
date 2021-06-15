package com.hawaso.javacampus.controllers;

import java.util.List;
import java.util.Optional;

import com.hawaso.javacampus.models.Shirt;
import com.hawaso.javacampus.repositories.ShirtRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shirts")
public class ShirtsController {
    @Autowired
    private ShirtRepository _shirtRepository;

    // 출력
    @GetMapping
    public List<Shirt> getAll() {
        return _shirtRepository.findAll();
    }

    // 입력
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shirt add(@RequestBody final Shirt shirt) {
        return _shirtRepository.saveAndFlush(shirt);
    }

    // 상세
    @GetMapping
    @RequestMapping("{id}")
    public Optional<Shirt> getById(@PathVariable Integer id) {
        return _shirtRepository.findById(id); 
    }

    // 수정
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Shirt update(@PathVariable Integer id, @RequestBody Shirt shirt) {
        var oldShirt = _shirtRepository.getById(id);
        BeanUtils.copyProperties(shirt, oldShirt, "id");
        return _shirtRepository.saveAndFlush(oldShirt);
    }

    // 삭제
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        _shirtRepository.deleteById(id);
    }
}
