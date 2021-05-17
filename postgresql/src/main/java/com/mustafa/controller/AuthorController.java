package com.mustafa.controller;

import com.mustafa.dto.AuthorDto;
import com.mustafa.service.abstracts.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorService.save(authorDto));
    }
    @GetMapping
    public ResponseEntity<List<AuthorDto>> listAll(){
        return ResponseEntity.ok(authorService.getAll());
    }


}
