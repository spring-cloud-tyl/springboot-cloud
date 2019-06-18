package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.elasticsearch.model.School;
import com.example.demo.elasticsearch.model.Student;
import com.example.demo.elasticsearch.model.Teacher;
import com.example.demo.elasticsearch.repository.BaseRepository;
import com.example.demo.elasticsearch.repository.TeacherRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author tangyulin
 * @description
 * @createdate 11/30/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {

    @Resource
    TeacherRepository teacherRepository;

    @Test
    public void test() {
        School s1 = new School();
        s1.setId(UUID.randomUUID().toString());
        s1.setName("华东师范大学");
        s1.setProvince("上海");

        School s2 = new School();
        s2.setId(UUID.randomUUID().toString());
        s2.setName("中国科技大学");
        s2.setProvince("安徽");

        School s3 = new School();
        s3.setId(UUID.randomUUID().toString());
        s3.setName("清华大学");
        s3.setProvince("河北");

        Teacher t1 = new Teacher();
        t1.setAge(32);
        t1.setId(UUID.randomUUID().toString());
        t1.setBornDate(LocalDate.now().minusYears(32).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        t1.setName("张老师");
        t1.setSchool(s1);
        t1.setSex("男");

        Teacher t2 = new Teacher();
        t2.setAge(34);
        t2.setId(UUID.randomUUID().toString());
        t2.setBornDate(LocalDate.now().minusYears(34).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        t2.setName("王老师");
        t2.setSchool(s1);
        t2.setSex("女");

        Teacher t3 = new Teacher();
        t3.setAge(34);
        t3.setId(UUID.randomUUID().toString());
        t3.setBornDate(LocalDate.now().minusYears(34).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        t3.setName("刘老师");
        t3.setSchool(s2);
        t3.setSex("男");

        Teacher t4 = new Teacher();
        t4.setAge(28);
        t4.setId(UUID.randomUUID().toString());
        t4.setBornDate(LocalDate.now().minusYears(28).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        t4.setName("陈老师");
        t4.setSchool(s3);
        t4.setSex("女");


        Teacher t5 = new Teacher();
        t5.setAge(28);
        t5.setId(UUID.randomUUID().toString());
        t5.setBornDate(LocalDate.now().minusYears(28).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        t5.setName("董老师");
        t5.setSchool(s2);
        t5.setSex("女");


        List<Student> studentList1 = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();
        List<Student> studentList3 = new ArrayList<>();
        List<Student> studentList4 = new ArrayList<>();
        List<Student> studentList5 = new ArrayList<>();

        Student st1 = new Student();
        st1.setId(UUID.randomUUID().toString());
        st1.setAge(23);
        st1.setName("张三");
        st1.setSchool(s1);
        st1.setSex("女");
        st1.setStartDate(LocalDate.now().minusYears(4).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList1.add(st1);

        Student st2 = new Student();
        st2.setId(UUID.randomUUID().toString());
        st2.setAge(24);
        st2.setName("李四");
        st2.setSchool(s1);
        st2.setSex("男");
        st2.setStartDate(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList1.add(st2);


        Student st3 = new Student();
        st3.setId(UUID.randomUUID().toString());
        st3.setAge(24);
        st3.setName("贾某");
        st3.setSchool(s1);
        st3.setSex("男");
        st3.setStartDate(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList1.add(st3);

        Student st4 = new Student();
        st4.setId(UUID.randomUUID().toString());
        st4.setAge(24);
        st4.setName("乙");
        st4.setSchool(s1);
        st4.setSex("男");
        st4.setStartDate(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList2.add(st4);

        Student st5 = new Student();
        st5.setId(UUID.randomUUID().toString());
        st5.setAge(24);
        st5.setName("丙");
        st5.setSchool(s2);
        st5.setSex("女");
        st5.setStartDate(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList2.add(st5);

        Student st6 = new Student();
        st6.setId(UUID.randomUUID().toString());
        st6.setAge(24);
        st6.setName("丁");
        st6.setSchool(s2);
        st6.setSex("男");
        st6.setStartDate(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList3.add(st2);

        Student st7 = new Student();
        st7.setId(UUID.randomUUID().toString());
        st7.setAge(25);
        st7.setName("戊庚辛");
        st7.setSchool(s3);
        st7.setSex("女");
        st7.setStartDate(LocalDate.now().minusYears(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList4.add(st7);

        Student st8 = new Student();
        st8.setId(UUID.randomUUID().toString());
        st8.setAge(25);
        st8.setName("己");
        st8.setSchool(s3);
        st8.setSex("男");
        st8.setStartDate(LocalDate.now().minusYears(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        studentList5.add(st8);

        t1.setStudentList(studentList1);
        t2.setStudentList(studentList2);
        t3.setStudentList(studentList3);
        t4.setStudentList(studentList4);
        t5.setStudentList(studentList5);

        Teacher teacher = teacherRepository.save(t1);
        teacherRepository.save(t2);
        teacherRepository.save(t3);
        teacherRepository.save(t4);
        teacherRepository.save(t5);
        String string = JSONObject.toJSONString(teacher);
        System.out.println(string);

    }


}
