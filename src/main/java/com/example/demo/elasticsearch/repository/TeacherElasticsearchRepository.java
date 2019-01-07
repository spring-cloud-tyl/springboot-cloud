package com.example.demo.elasticsearch.repository;

import com.example.demo.elasticsearch.model.Teacher;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author tangyulin
 * @description
 * @createdate 12/09/2018
 */
public interface TeacherElasticsearchRepository extends ElasticsearchRepository<Teacher,String> {


}
