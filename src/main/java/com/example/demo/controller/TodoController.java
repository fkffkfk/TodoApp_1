package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("todo")
public class TodoController {
    @Autowired
    private TodoService service;
    @GetMapping("/test")
    public ResponseEntity<?> testTodo(){
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/testTodo")
    public String TodoController(@RequestBody TodoDTO todoDTO){
        return "id : "+todoDTO.getId()
                +" title : "+todoDTO.getTitle()
                +" done : "+todoDTO.isDone();
    }
    /*ResponseEntity<?> testTodo(){
        ResponseDTO<String> response =ResponseDTO.<String>builder().build();
        return ResponseEntity.ok().body(response);
    }*/
}
