package com.example.service;

import com.example.dto.StudentDto;
import com.example.mapper.StudentMapper;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper mapper;

    public List<StudentDto> getStudents(){
        return studentRepository.findAll().stream()
                .map(e -> mapper.mapStudentDto(e))
                .collect(Collectors.toList());
    }

    public void saveStudentToDataBase(StudentDto studentDto) {
        Student student = mapper.mapStudent(studentDto);
        studentRepository.save(student);
    }

//    public Student getStudentById(int idstudent) {
//        Optional<Student> student = studentRepository.findById(idstudent);
//        return student.get();
//    }

    public void deleteStudentById(int idStudent) {
        studentRepository.delete(studentRepository.getById(idStudent));
    }


}

