package com.weg.atv_turismo_jpa.service.hospedagem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemRequestDto;
import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemResponseDto;
import com.weg.atv_turismo_jpa.mapper.HospedagemMapper;
import com.weg.atv_turismo_jpa.model.Hospedagem;
import com.weg.atv_turismo_jpa.repository.HospedagemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospedagemServiceImpl implements HospedagemService{
    
    private final HospedagemRepository hospedagemRepository;

    private final HospedagemMapper hospedagemMapper;

    @Override
    public HospedagemResponseDto save(HospedagemRequestDto hospedagemRequestDto) {
        if(hospedagemRepository.existsByNome(hospedagemRequestDto.nome())){
            throw new RuntimeException("Hospedagem já cadastrada");
        }
        Hospedagem hospedagem = hospedagemMapper.toEntity(hospedagemRequestDto);
        
        hospedagemRepository.save(hospedagem);

        return hospedagemMapper.toResponse(hospedagem);
    }

    @Override
    public HospedagemResponseDto get(Long id) {
        Hospedagem hospedagem = hospedagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Hospedagem não encontrada"));

        return hospedagemMapper.toResponse(hospedagem);
    }

    @Override
    public List<HospedagemResponseDto> getAll() {
        List<Hospedagem> hospedagens = hospedagemRepository.findAll();
        if(hospedagens.size() == 0){
            throw new RuntimeException("Nenhuma hospedagem encontrada");
        }

        return hospedagens.stream().map(hospedagemMapper::toResponse).toList();
    }

    @Override
    public HospedagemResponseDto update(Long id, HospedagemRequestDto hospedagemRequestDto) {
        Hospedagem hospedagem = hospedagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Hospedagem não encontrada"));

        hospedagem.setCheckin(hospedagemRequestDto.checkin());
        hospedagem.setCheckout(hospedagemRequestDto.checkout());
        hospedagem.setNome(hospedagemRequestDto.nome());
        hospedagem.setReserva(hospedagemRequestDto.reserva());

        hospedagemRepository.save(hospedagem);

        return hospedagemMapper.toResponse(hospedagem);
    }

    @Override
    public void delete(Long id) {
        if(!hospedagemRepository.existsById(id)){
            throw new RuntimeException("Hospedagem não encontrada");
        }
        hospedagemRepository.deleteById(id);
    }
    
}
