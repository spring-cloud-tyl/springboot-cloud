package com.example.demo;

import com.example.demo.elasticsearch.model.Teacher;
import com.example.demo.elasticsearch.repository.TeacherElasticsearchRepository;
import org.apache.lucene.search.join.JoinUtil;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author tangyulin
 * @description
 * @createdate 11/30/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherElasticsearchTest {

    @Resource
    TeacherElasticsearchRepository teacherElasticsearchRepository;

    @Test
    public void test() {


        /*GET /index/teacher/_search
        {
            "query": {
            "bool": {
                "must": [
                {"match": {
                    "sex": "女"
                }}
      ],
                "filter": {
                    "term": {
                        "school.name": "清华大学"
                    }
                }
            }
        }
        }*/
        QueryBuilder queryBuilder = QueryBuilders.termQuery("sex", "女");
        QueryBuilder filterBuilder = QueryBuilders.termQuery("school.name", "清华大学");
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder, filterBuilder);
        Iterable<Teacher> search = teacherElasticsearchRepository.search(searchQuery);
        search.forEach(teacher -> System.out.println(teacher.getName()));


       /* GET index/teacher/_search
        {
            "query": {
            "bool": {
                "must": [
                {"term": {
                    "sex": {
                        "value": "女"
                    }
                }
                },
                {"bool": {
                    "must": [
                    {"term": {
                        "school.name": {
                            "value": "华"
                        }
                    }}
          ]
                }},{
                    "bool": {"must": [
                        {"term": {
                            "school.name": {
                                "value": "清"
                            }
                        }}
          ]}
                }
      ]
            }
        }
        }*/
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("school.name", "清"));
        boolQueryBuilder.must(QueryBuilders.termQuery("school.name", "华"));
        boolQueryBuilder.must(QueryBuilders.termQuery("school.name", "大"));
        boolQueryBuilder.must(QueryBuilders.termQuery("school.name", "学"));
        Iterable<Teacher> search = teacherElasticsearchRepository.search(boolQueryBuilder);
        search.forEach(teacher -> System.out.println(teacher.getName()));


        //嵌套查询
        NestedQueryBuilder nestedQueryBuilder = QueryBuilders.nestedQuery("studentList", QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("studentList.sex", "女")
                ).must(QueryBuilders.termQuery("studentList.age", "23")), ScoreMode.None);
        Iterable<Teacher> search1 = teacherElasticsearchRepository.search(nestedQueryBuilder);
        search1.forEach(teacher -> System.out.println(teacher.getName()));

        QueryBuilder queryBuilder1 = QueryBuilders.termQuery("sex", "女");
        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("avg_age").field("age");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryBuilder1);
        nativeSearchQuery.addAggregation(avgAggregationBuilder);
        Page<Teacher> search2 = teacherElasticsearchRepository.search(nativeSearchQuery);
        search2.forEach(teacher -> System.out.println(teacher.getName()));


    }

}
