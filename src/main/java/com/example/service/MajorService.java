package com.example.service;


import com.example.dto.MajorDto;
import com.example.entity.Major;
import com.example.mapper.MajorMapper;
import com.example.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorService {

    @Autowired
    MajorRepository majorRepository;

    @Autowired
    MajorMapper mapper;

    public List<MajorDto> getMajor(){
        return majorRepository.findAll().stream()
                .map(e -> mapper.mapMajorDto(e))
                .collect(Collectors.toList());
    }

    public void saveMajorToDataBase(MajorDto majorDto) {
        Major major = mapper.mapMajor(majorDto);
        majorRepository.save(major);
    }

//    public Specializare getspecializareById(int idspecializare) {
//        Optional<Specializare> specializare = specializareRepository.findById(idspecializare);
//        return specializare.get();
//    }

    public void deleteMajorById(int id) {
        majorRepository.delete(majorRepository.getById(id));
    }

}
