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

import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroRequestDto;
import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroResponseDto;
import com.weg.atv_turismo_jpa.service.roteiro.RoteiroServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roteiros")
@RequiredArgsConstructor
public class RoteiroController {
    
    private final RoteiroServiceImpl serviceImpl;

    @PostMapping
    public RoteiroResponseDto postRoteiro(@RequestBody RoteiroRequestDto roteiroRequestDto){
        try{
            return serviceImpl.save(roteiroRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public RoteiroResponseDto getRoteiro(@PathVariable Long id){
        try{
            return serviceImpl.get(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<RoteiroResponseDto> getRoteiros(){
        try{
            return serviceImpl.getAll();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public RoteiroResponseDto putRoteiro(@PathVariable Long id, @RequestBody RoteiroRequestDto roteiroRequestDto){
        try{
            return serviceImpl.update(id, roteiroRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRoteiro(@PathVariable Long id){
        try{
            serviceImpl.delete(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}   
