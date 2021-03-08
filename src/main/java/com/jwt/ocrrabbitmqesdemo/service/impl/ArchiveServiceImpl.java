package com.jwt.ocrrabbitmqesdemo.service.impl;

import com.jwt.ocrrabbitmqesdemo.dao.ArchiveDao;
import com.jwt.ocrrabbitmqesdemo.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.entity.Archive;
import com.jwt.ocrrabbitmqesdemo.service.ArchiveServie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArchiveServiceImpl implements ArchiveServie {

    @Autowired
    private ArchiveDao archiveDao;

    @Override
    public List<ArchiveDto> getByName(String name) {
        List<ArchiveDto> archiveDtoList = null;
        List<Archive> archiveList = archiveDao.findByTm(name);
        if(!CollectionUtils.isEmpty(archiveList)) {
            archiveDtoList = archiveList.parallelStream().map(archive -> {
                ArchiveDto archiveDto = new ArchiveDto();
                BeanUtils.copyProperties(archive, archiveDto);
                return archiveDto;
            }).collect(Collectors.toList());
        }
        return archiveDtoList;
    }

    @Override
    public void save(ArchiveDto archiveDto) {
        Archive archive = new Archive();
        BeanUtils.copyProperties(archiveDto, archive);
        archiveDao.save(archive);
    }
}
