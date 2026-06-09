package com.weg.atv_turismo_jpa.service.turista;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.atv_turismo_jpa.dto.turista.TuristaRequestDto;
import com.weg.atv_turismo_jpa.dto.turista.TuristaResponseDto;
import com.weg.atv_turismo_jpa.mapper.TuristaMapper;
import com.weg.atv_turismo_jpa.model.Turista;
import com.weg.atv_turismo_jpa.repository.TuristaRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TuristaServiceImpl implements TuristaService{

    private final TuristaRespository respository;

    private final TuristaMapper mapper;

    @Override
    public TuristaResponseDto save(TuristaRequestDto turistaRequestDto) {
        if(respository.existsByNome(turistaRequestDto.nome())){
            throw new RuntimeException("Turista com nome já cadastrado");
        }
        Turista turista = mapper.toEntity(turistaRequestDto);
        respository.save(turista);
        return mapper.toResponse(turista); 
    }

    @Override
    public TuristaResponseDto get(Long id) {
        Turista turista = respository.findById(id).orElseThrow(() -> new RuntimeException("Turista não encontrado"));

        return mapper.toResponse(turista);
    }

    @Override
    public List<TuristaResponseDto> getAll() {
        List<Turista> turistas = respository.findAll();
        return turistas.stream().map(mapper::toResponse).toList();
    }

    @Override
    public TuristaResponseDto update(Long id, TuristaRequestDto turistaRequestDto) {
        Turista turista = respository.findById(id).orElseThrow(() -> new RuntimeException("Turista não encontrado"));

        turista.setNacionalidade(turistaRequestDto.nacionalidade());
        turista.setNome(turistaRequestDto.nome());
        turista.setNumero(turistaRequestDto.numero());
        turista.setPassaporte(turistaRequestDto.passaporte());

        respository.save(turista);

        return mapper.toResponse(turista);
    }

    @Override
    public void delete(Long id) {
        if(!respository.existsById(id)){
            throw new RuntimeException("Turista inexistente");
        }
        respository.deleteById(id);
    }

}
