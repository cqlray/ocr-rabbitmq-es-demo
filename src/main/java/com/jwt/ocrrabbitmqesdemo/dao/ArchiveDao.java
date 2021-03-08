package com.jwt.ocrrabbitmqesdemo.dao;

import com.jwt.ocrrabbitmqesdemo.entity.Archive;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveDao extends ElasticsearchRepository<Archive, Integer> {
    List<Archive> findByTm(String tm);

}
