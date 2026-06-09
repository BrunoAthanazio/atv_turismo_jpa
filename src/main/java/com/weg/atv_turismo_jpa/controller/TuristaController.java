package com.weg.atv_turismo_jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.atv_turismo_jpa.dto.turista.TuristaRequestDto;
import com.weg.atv_turismo_jpa.dto.turista.TuristaResponseDto;
import com.weg.atv_turismo_jpa.service.turista.TuristaServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/turistas")
@RequiredArgsConstructor
public class TuristaController {

    private final TuristaServiceImpl serviceImpl;

    @PostMapping
    public TuristaResponseDto postTurista(@RequestBody TuristaRequestDto turistaRequestDto){
        try{
            return serviceImpl.save(turistaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TuristaResponseDto> getTuristas(){
        try{
            return serviceImpl.getAll();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public TuristaResponseDto getTurista(@PathVariable Long id){
        try{
            return serviceImpl.get(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public TuristaResponseDto putTurista(@PathVariable Long id, @RequestBody TuristaRequestDto turistaRequestDto){
        try{
            return serviceImpl.update(id, turistaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTurista(@PathVariable Long id){
        try{
            serviceImpl.delete(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
