package com.jwt.ocrrabbitmqesdemo.web.controller;

import com.jwt.ocrrabbitmqesdemo.facade.es.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.facade.es.service.ArchiveServie;
import com.jwt.ocrrabbitmqesdemo.facade.mq.servie.MessageQueueSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "测试接口")
@RestController
@RequestMapping(value = "/home",produces = "application/json")
public class HomeController {

    @Autowired
    ArchiveServie archiveServie;
    @Autowired
    MessageQueueSendService messageQueueSendService;

    @ApiOperation(value = "保存档案")
    @RequestMapping(value = "/saveArchive", method = RequestMethod.POST)
    public void saveArchive(@RequestBody ArchiveDto archiveDto){
        messageQueueSendService.sendArchiveMessage(archiveDto);
        archiveServie.save(archiveDto);
    }

    @ApiOperation(value = "根据名称查询档案")
    @RequestMapping(value = "/getArchiveByName", method = RequestMethod.GET)
    public ArchiveDto getArchiveByName(@RequestParam("name") @ApiParam("名称") String name) {
        messageQueueSendService.sendArchiveMessage(name);
        return archiveServie.getByName(name);
    }
}
