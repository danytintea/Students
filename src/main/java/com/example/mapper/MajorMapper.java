package com.example.mapper;

import com.example.dto.MajorDto;
import com.example.entity.Major;
import org.springframework.stereotype.Component;

@Component
public class MajorMapper {

    public MajorDto mapMajorDto(Major major) {
        return MajorDto.builder()
                .id(major.getId())
                .name(major.getName())
                .university(major.getUniversity())
                .college(major.getCollege())
                .office(major.getOffice())
                .build();

//        MajorDto majorDto = new MajorDto();
//        majorDto.setId(major.getId());
//        majorDto.setName(major.getName());
//        majorDto.setUniversity(major.getUniversity());
//        majorDto.setCollege(major.getCollege());
//        majorDto.setOffice(major.getOffice());
//        return majorDto;
    }

    public Major mapMajor(MajorDto majorDto) {
        return Major.builder()
                .id(majorDto.getId())
                .name(majorDto.getName())
                .university(majorDto.getUniversity())
                .college(majorDto.getCollege())
                .office(majorDto.getOffice())
                .build();

//        Major major = new Major();
//        major.setId(majorDto.getId());
//        major.setName(majorDto.getName());
//        major.setUniversity(majorDto.getUniversity());
//        major.setCollege(majorDto.getCollege());
//        major.setOffice(majorDto.getOffice());
//        return major;
    }

}
