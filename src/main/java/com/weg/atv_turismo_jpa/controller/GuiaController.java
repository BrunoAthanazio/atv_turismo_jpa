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

import com.weg.atv_turismo_jpa.dto.guia.GuiaRequestDto;
import com.weg.atv_turismo_jpa.dto.guia.GuiaResponseDto;
import com.weg.atv_turismo_jpa.service.guia.GuiaServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/guias")
@RequiredArgsConstructor
public class GuiaController {
    private final GuiaServiceImpl serviceImpl;

    @PostMapping
    public GuiaResponseDto postGuia(@RequestBody GuiaRequestDto guiaRequestDto){
        try{
            return serviceImpl.save(guiaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public GuiaResponseDto getGuia(@PathVariable Long id){
        try{
            return serviceImpl.get(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<GuiaResponseDto> getGuias(){
        try{
            return serviceImpl.getAll();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public GuiaResponseDto putGuia(@PathVariable Long id, @RequestBody GuiaRequestDto guiaRequestDto){
        try{
            return serviceImpl.update(id, guiaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGuia(@PathVariable Long id){
        try{
            serviceImpl.delete(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
