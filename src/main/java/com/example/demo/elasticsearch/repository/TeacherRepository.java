package com.example.demo.elasticsearch.repository;

import com.example.demo.elasticsearch.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @author tangyulin
 * @description
 * @createdate 12/09/2018
 */
public interface TeacherRepository extends BaseRepository<Teacher, String> {


    /**
     * 直接属性查询
     *
     * @return
     */

    //List<Teacher> findByName(String name);

    long count();

    List<Teacher> findByNameAndAge(String name, int age);

    List<Teacher> findByAgeGreaterThan(int age);

    /**
     * 间接属性查询
     *
     * @return
     */
    List<Teacher> findBySchoolName(String name);


    /**
     * 分页、排序
     */

    //Page<Teacher> findByName(String name, Pageable pageable);

    Page<Teacher> findFirst10ByName(String name, Pageable pageable);

    /**
     * 流式查询
     */

    Stream<Teacher> streamAllByAge(int age);

  /* @Query("select t from Teacher t")
   Page<Teacher> findByName(String name, Pageable pageable);
*/

    /**
     * 异步查询
     */

    @Async
    Future<Teacher> findByName(String name);


}