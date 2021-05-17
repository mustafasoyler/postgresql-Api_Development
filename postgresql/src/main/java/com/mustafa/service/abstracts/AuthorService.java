package com.mustafa.service.abstracts;

import com.mustafa.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto save(AuthorDto authorDto);
    void delete(Integer id);
    List<AuthorDto> getAll();
}
