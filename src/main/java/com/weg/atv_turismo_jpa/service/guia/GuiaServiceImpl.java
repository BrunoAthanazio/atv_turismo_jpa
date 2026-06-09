package com.weg.atv_turismo_jpa.service.guia;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.atv_turismo_jpa.dto.guia.GuiaRequestDto;
import com.weg.atv_turismo_jpa.dto.guia.GuiaResponseDto;
import com.weg.atv_turismo_jpa.mapper.GuiaMapper;
import com.weg.atv_turismo_jpa.model.Guia;
import com.weg.atv_turismo_jpa.repository.GuiaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuiaServiceImpl implements GuiaService{

    private final GuiaRepository guiaRepository;

    private final GuiaMapper guiaMapper;

    @Override
    public GuiaResponseDto save(GuiaRequestDto guiaRequestDto) {
        if(guiaRepository.existsByNome(guiaRequestDto.nome())){
            throw new RuntimeException("O Guia já foi cadastrado");
        }

        Guia guia = guiaMapper.toEntity(guiaRequestDto);

        guiaRepository.save(guia);

        return guiaMapper.toResponseDto(guia);
    }

    @Override
    public GuiaResponseDto get(Long id) {

        Guia guia = guiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Guia não encontrado"));

        return guiaMapper.toResponseDto(guia);
    }

    @Override
    public List<GuiaResponseDto> getAll() {
        List<Guia> guias = guiaRepository.findAll();
        if(guias.size() == 0){
            throw new RuntimeException("Nenhum guia encontrado");
        }
        return guias.stream().map(guiaMapper::toResponseDto).toList();
    }

    @Override
    public GuiaResponseDto update(Long id, GuiaRequestDto guiaRequestDto) {
        Guia guia = guiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Guia não encontrado"));

        guia.setEspecialidade(guiaRequestDto.especialidade());
        guia.setIdade(guiaRequestDto.idade());
        guia.setNacionalidade(guiaRequestDto.nacionalidade());
        guia.setNome(guiaRequestDto.nome());

        guiaRepository.save(guia);

        return guiaMapper.toResponseDto(guia);
    }

    @Override
    public void delete(Long id) {
        if(!guiaRepository.existsById(id)){
            throw new RuntimeException("Guia não encontrado");
        }

        guiaRepository.deleteById(id);
    }

}
