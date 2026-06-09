package com.weg.atv_turismo_jpa.service.transporte;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.atv_turismo_jpa.dto.transporte.TransporteRequestDto;
import com.weg.atv_turismo_jpa.dto.transporte.TransporteResponseDto;
import com.weg.atv_turismo_jpa.mapper.TransporteMapper;
import com.weg.atv_turismo_jpa.model.Transporte;
import com.weg.atv_turismo_jpa.repository.TransporteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransporteServiceImpl implements TransporteService{

    private final TransporteRepository repository;
    private final TransporteMapper mapper;

    @Override
    public TransporteResponseDto save(TransporteRequestDto transporteRequestDto) {
        if(repository.existsByNome(transporteRequestDto.nome())){
            throw new RuntimeException("Transporte já cadastrado");
        }
        Transporte transporte = mapper.toEntity(transporteRequestDto);

        repository.save(transporte);

        return mapper.toResponse(transporte);
    }
    
    @Override
    public TransporteResponseDto get(Long id) {
        Transporte transporte = repository.findById(id).orElseThrow(() -> new RuntimeException("Transporte não encontrado"));

        return mapper.toResponse(transporte);
    }

    @Override
    public List<TransporteResponseDto> getAll() {
        List<Transporte> transportes = repository.findAll();
        
        return transportes.stream().map(mapper::toResponse).toList();
    }

    @Override
    public TransporteResponseDto update(Long id, TransporteRequestDto transporteRequestDto) {
        Transporte transporte = repository.findById(id).orElseThrow(() -> new RuntimeException());

        transporte.setDestino(transporteRequestDto.destino());
        transporte.setNome(transporteRequestDto.nome());
        transporte.setPartida(transporteRequestDto.partida());
        transporte.setTipo(transporteRequestDto.tipo());

        repository.save(transporte);

        return mapper.toResponse(transporte);
    }
    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Transporte inexistente");
        }

        repository.deleteById(id);
    }
}