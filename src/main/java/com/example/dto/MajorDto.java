package com.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
@Builder
public class MajorDto {

    private int id;
    private String name;
    private String university;
    private String college;
    private String office;
}
