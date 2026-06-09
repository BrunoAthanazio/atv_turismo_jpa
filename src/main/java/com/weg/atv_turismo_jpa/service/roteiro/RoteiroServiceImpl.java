package com.weg.atv_turismo_jpa.service.roteiro;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroRequestDto;
import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroResponseDto;
import com.weg.atv_turismo_jpa.mapper.RoteiroMapper;
import com.weg.atv_turismo_jpa.model.Roteiro;
import com.weg.atv_turismo_jpa.repository.RoteiroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoteiroServiceImpl implements RoteiroService{

    private final RoteiroRepository roteiroRepository;

    private final RoteiroMapper roteiroMapper;
    
    @Override
    public RoteiroResponseDto save(RoteiroRequestDto roteiroRequestDto) {
        if(roteiroRepository.existsByLocal(roteiroRequestDto.local())){
            throw new RuntimeException("Roteiro já cadastrado no mesmo local");
        }
        Roteiro roteiro = roteiroMapper.toEntity(roteiroRequestDto);

        roteiroRepository.save(roteiro);

        return roteiroMapper.toResponseDTO(roteiro);
    }

    @Override
    public RoteiroResponseDto get(Long id) {
        Roteiro roteiro = roteiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Roteiro não encontrado"));

        return roteiroMapper.toResponseDTO(roteiro);
    }

    @Override
    public List<RoteiroResponseDto> getAll() {
        List<Roteiro> roteiros = roteiroRepository.findAll();
        if(roteiros.size() == 0){
            throw new RuntimeException("Nenhum roteiro encontrado");
        }
        return roteiros.stream().map(roteiroMapper::toResponseDTO).toList();
    }

    @Override
    public RoteiroResponseDto update(Long id, RoteiroRequestDto roteiroRequestDto) {
        Roteiro roteiro = roteiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Roteiro não encontrado"));

        roteiro.setCapacidade_max(roteiroRequestDto.capacidade_max());
        roteiro.setHora_chegada(roteiroRequestDto.hora_chegada());
        roteiro.setHora_saida(roteiroRequestDto.hora_saida());
        roteiro.setLocal(roteiroRequestDto.local());

        roteiroRepository.save(roteiro);

        return roteiroMapper.toResponseDTO(roteiro);
    }

    @Override
    public void delete(Long id) {
        if(!roteiroRepository.existsById(id)){
            throw new RuntimeException("Roteiro inexistente");
        }

        roteiroRepository.deleteById(id);
    }

}
