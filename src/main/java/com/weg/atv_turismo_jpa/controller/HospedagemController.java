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

import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemRequestDto;
import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemResponseDto;
import com.weg.atv_turismo_jpa.service.hospedagem.HospedagemServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hospedagens")
@RequiredArgsConstructor
public class HospedagemController {

    private final HospedagemServiceImpl serviceImpl;

    @PostMapping
    public HospedagemResponseDto postHospedagem(@RequestBody HospedagemRequestDto hospedagemRequestDto){
        try{
            return serviceImpl.save(hospedagemRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public HospedagemResponseDto getHospedagem(@PathVariable Long id){
        try{
            return serviceImpl.get(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<HospedagemResponseDto> getHospedagens(){
        try{
            return serviceImpl.getAll();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public HospedagemResponseDto putHospedagem(@PathVariable Long id, @RequestBody HospedagemRequestDto hospedagemRequestDto){
        try{
            return serviceImpl.update(id, hospedagemRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHospedagem(@PathVariable Long id){
        try{
            serviceImpl.delete(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
