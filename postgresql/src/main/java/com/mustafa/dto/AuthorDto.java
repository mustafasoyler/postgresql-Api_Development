package com.mustafa.dto;

import lombok.Data;
import java.util.List;

@Data
public class AuthorDto {

    private int id;

    private String name;

    private String surname;

    private List<String> bookList;

}
