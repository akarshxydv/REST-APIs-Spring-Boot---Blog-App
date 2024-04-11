package com.example.Springbootrestapi.controller;

import com.example.Springbootrestapi.models.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("stuf")  this is used for parent base url for all method
public class StudentController {

    @GetMapping("/students")
    public Students student(){
        Students students=new Students(1,"Akarsh","LPU");
        return students;
    }
    @GetMapping("/studen")
    public ResponseEntity<Students> studentsResponseEntity(){
        Students students=new Students(1,"Akarsh","LPU");
        //return new ResponseEntity<>(students,HttpStatus.OK);

        return ResponseEntity.ok()
                .header("custom-header","Akki")
                .body(students);
    }

    @GetMapping("/student")
    public List<Students> students(){
        List<Students> list=new ArrayList<>();
        list.add(new Students(1,"Akarsh","LPU"));
        list.add(new Students(2,"Aviral","srm"));
        list.add(new Students(3,"Ansh","vtu"));
        list.add(new Students(4,"Aditya","cu"));

        return list;

    }

    @GetMapping("/studentR")
    public ResponseEntity<List<Students>> studentsR(){
        List<Students> list=new ArrayList<>();
        list.add(new Students(1,"Akarsh","LPU"));
        list.add(new Students(2,"Aviral","srm"));
        list.add(new Students(3,"Ansh","vtu"));
        list.add(new Students(4,"Aditya","cu"));

        return ResponseEntity.ok(list);

    }

    //   spring boot rest api with path variable
   // {} ->  uri template variable

    @GetMapping("/students/{id}")
    public Students students(@PathVariable("id") int studentId){
        return new Students(studentId,"Akarsh","LPU");
    }


    //   spring boot rest api with Request Param
    // {} ->  uri template variable
    // localhost:8080/students/querry?id=1
    @GetMapping("/students/querry")
    public Students studentsRequest(@RequestParam int studentId){
        return new Students(studentId,"Akarsh","LPU");
    }

    //   spring boot api with post mapping  -- this http request handle the creating new resource

    @PostMapping("students/created")
    @ResponseStatus(HttpStatus.CREATED)
    public Students students(@RequestBody Students students){
        System.out.println(students.id());
        System.out.println(students.name());
        System.out.println(students.collage());
        return students;
    }

    //  spring boot rest api with put mapping  --  this hh=ttp request handle the updating the resource

    @PutMapping("students/{id}/update")
    public Students studentsUpdate(@RequestBody Students students, @PathVariable("id") int studentId ){

        System.out.println(students.name());
        System.out.println(students.collage());
        System.out.println(students.id());
        return students;
    }

    // spring boot api that handle request of delete resource

    @DeleteMapping("students/{id}/delete")
    public String studentsdelete(@PathVariable int id){
        System.out.println(id);
        return "successfully deleted";
    }


}
