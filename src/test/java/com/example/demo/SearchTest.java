package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.elasticsearch.model.School;
import com.example.demo.elasticsearch.model.Student;
import com.example.demo.elasticsearch.model.Teacher;
import com.example.demo.elasticsearch.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author tangyulin
 * @description
 * @createdate 11/30/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchTest {

    @Resource
    TeacherRepository teacherRepository;

    @Test
    public void test() throws ExecutionException, InterruptedException {
        School school = new School();
        school.setName("清华大学");
        school.setId("4606005a-d1bf-4713-b24d-34b6027e136a");
        school.setProvince("河北");
        //List<Teacher> teacherList = teacherRepository.findBySchoolName("华东师范大学");
        // List<Teacher> teacherList = teacherRepository.findBySchoolName("清华大学");
        // long count = teacherRepository.count();
        teacherRepository.findBySchoolName("清华大学");
       // Page<Teacher> teacher = teacherRepository.findByName("张老师", PageRequest.of(1, 10));
        Stream<Teacher> teacherStream = teacherRepository.streamAllByAge(32);
        Future<Teacher> teachers = teacherRepository.findByName("张老师");
        Teacher teacher = teachers.get();
        String string = JSONObject.toJSONString(teacher);
        System.out.println(string);

    }


}
