package com.example.mapper;

import com.example.dto.MajorDto;
import com.example.dto.StudentDto;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto mapStudentDto(Student student) {
        MajorDto majorDto = MajorDto.builder()
                .id(student.getMajor().getId())
                .name(student.getMajor().getName())
                .university(student.getMajor().getUniversity())
                .college(student.getMajor().getCollege())
                .office(student.getMajor().getOffice())
                .build();

        return StudentDto.builder()
                .id(student.getId())
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .email(student.getEmail())
                .year(student.getYear())
                .major(majorDto)
                .build();

//        StudentDto studentDto = new StudentDto();
//        studentDto.setId(student.getId());
//        studentDto.setLastName(student.getLastName());
//        studentDto.setFirstName(student.getFirstName());
//        studentDto.setEmail(student.getEmail());
//        studentDto.setYear(student.getYear());
//        studentDto.setMajor(student.getMajor());
//        return studentDto;
    }

    public Student mapStudent(StudentDto studentDto) {

        MajorMapper majorMapper = new MajorMapper();

        return Student.builder()
                .id(studentDto.getId())
                .lastName(studentDto.getLastName())
                .firstName(studentDto.getFirstName())
                .email(studentDto.getEmail())
                .year(studentDto.getYear())
                .major(majorMapper.mapMajor(studentDto.getMajor()))
                .build();

//        Student student = new Student();
//        student.setId(studentDto.getId());
//        student.setLastName(studentDto.getLastName());
//        student.setFirstName(studentDto.getFirstName());
//        student.setEmail(studentDto.getEmail());
//        student.setYear(studentDto.getYear());
//        student.setMajor(studentDto.getMajor());
//        return student;
    }
}
