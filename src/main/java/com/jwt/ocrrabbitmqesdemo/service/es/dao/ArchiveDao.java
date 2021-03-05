package com.jwt.ocrrabbitmqesdemo.service.es.dao;

import com.jwt.ocrrabbitmqesdemo.service.es.entity.Archive;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveDao extends ElasticsearchRepository<Archive, Integer> {
    Archive findByTm(String tm);
}
