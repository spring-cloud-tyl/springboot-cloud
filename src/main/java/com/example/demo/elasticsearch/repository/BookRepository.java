package com.example.demo.elasticsearch.repository;

import com.example.demo.elasticsearch.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangyulin
 * @description
 * @createdate 11/30/2018
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {


}
