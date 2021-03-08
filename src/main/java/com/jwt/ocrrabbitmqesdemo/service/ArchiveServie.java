package com.jwt.ocrrabbitmqesdemo.service;

import com.jwt.ocrrabbitmqesdemo.dto.ArchiveDto;

import java.util.List;

public interface ArchiveServie {

    List<ArchiveDto> getByName(String name);

    void save(ArchiveDto archiveDto);
}
