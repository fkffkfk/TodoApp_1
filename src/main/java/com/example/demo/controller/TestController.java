package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
 @GetMapping("/testGetMapping")
    public String testController(){
     return "Hello world, dbsduddk";
 }
 @GetMapping("/testRequestParam")
 public String testControllerWithRequestParam(@RequestParam(required = false)int id){
    return "Hello world ID: "+id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerWithRequestParam(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello world,윤영아.ID: "+testRequestBodyDTO.getId()+".message:" +
                testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("csh");
        list.add("csh2");
        list.add("cat");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("csh");
        list.add("csh2");
        list.add("cat");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        //return ResponseEntity.ok().body(response);
        return ResponseEntity.badRequest().body(response);
    }
    }

