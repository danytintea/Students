package com.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
@Builder
public class StudentDto {

    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private int year;
    private MajorDto major = new MajorDto();
}
