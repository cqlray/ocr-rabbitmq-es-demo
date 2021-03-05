package com.jwt.ocrrabbitmqesdemo.facade.es.service;

import com.jwt.ocrrabbitmqesdemo.facade.es.dto.ArchiveDto;

public interface ArchiveServie {

    ArchiveDto getByName(String name);

    void save(ArchiveDto archiveDto);
}
