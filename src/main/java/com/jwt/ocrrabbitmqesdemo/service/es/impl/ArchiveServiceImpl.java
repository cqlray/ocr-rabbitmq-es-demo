package com.jwt.ocrrabbitmqesdemo.service.es.impl;

import com.jwt.ocrrabbitmqesdemo.facade.es.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.facade.es.service.ArchiveServie;
import com.jwt.ocrrabbitmqesdemo.service.es.dao.ArchiveDao;
import com.jwt.ocrrabbitmqesdemo.service.es.entity.Archive;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveServiceImpl implements ArchiveServie {

    @Autowired
    ArchiveDao archiveDao;

    @Override
    public ArchiveDto getByName(String name) {
        Archive archive = archiveDao.findByTm(name);
        ArchiveDto archiveDto = new ArchiveDto();
        BeanUtils.copyProperties(archive, archiveDto);
        return archiveDto;
    }

    @Override
    public void save(ArchiveDto archiveDto) {
        Archive archive = new Archive();
        BeanUtils.copyProperties(archiveDto, archive);
        archiveDao.save(archive);
    }
}
