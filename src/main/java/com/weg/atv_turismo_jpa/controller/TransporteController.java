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

import com.weg.atv_turismo_jpa.dto.transporte.TransporteRequestDto;
import com.weg.atv_turismo_jpa.dto.transporte.TransporteResponseDto;
import com.weg.atv_turismo_jpa.service.transporte.TransporteServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transportes")
@RequiredArgsConstructor
public class TransporteController {

    private final TransporteServiceImpl service;

    @PostMapping
    public TransporteResponseDto postTransporte(@RequestBody TransporteRequestDto requestDto){
        try{
            return service.save(requestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TransporteResponseDto> getTransportes(){
        try{
            return service.getAll();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public TransporteResponseDto getTransporte(@PathVariable Long id){
        try{
            return service.get(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public TransporteResponseDto putTransporte(@PathVariable Long id, @RequestBody TransporteRequestDto transporteRequestDto){
        try{
            return service.update(id, transporteRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTransporte(@PathVariable Long id){
        try{
            service.delete(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
