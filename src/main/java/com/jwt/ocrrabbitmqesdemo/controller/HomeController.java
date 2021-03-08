package com.jwt.ocrrabbitmqesdemo.controller;

import com.jwt.ocrrabbitmqesdemo.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.dto.SubjectDto;
import com.jwt.ocrrabbitmqesdemo.service.ArchiveServie;
import com.jwt.ocrrabbitmqesdemo.service.MessageQueueSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "测试接口")
@RestController
@RequestMapping(value = "/home",produces = "application/json")
public class HomeController {

    @Autowired
    private ArchiveServie archiveServie;
    @Autowired
    private MessageQueueSendService messageQueueSendService;

    @ApiOperation(value = "保存档案")
    @RequestMapping(value = "/saveArchive", method = RequestMethod.POST)
    public void saveArchive(@RequestBody ArchiveDto archiveDto){
//        messageQueueSendService.sendArchiveMessage(archiveDto);
        archiveServie.save(archiveDto);
    }

    @ApiOperation(value = "根据名称查询档案")
    @RequestMapping(value = "/getArchiveByName", method = RequestMethod.GET)
    public List<ArchiveDto> getArchiveByName(@RequestParam("name") @ApiParam("名称") String name) {
//        messageQueueSendService.sendArchiveMessage(name);
        return archiveServie.getByName(name);
    }

    @ApiOperation(value = "发送档案到消息队列")
    @RequestMapping(value = "/sendArchiveMessage", method = RequestMethod.POST)
    public void sendArchiveMessage(@RequestBody ArchiveDto archiveDto){
        messageQueueSendService.sendArchiveMessage(archiveDto);
    }


    @ApiOperation(value = "发送消息到消息队列")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendArchiveMessage(@RequestBody String message){
        messageQueueSendService.sendArchiveMessage(message);
    }


    @ApiOperation(value = "发送延迟消息到消息队列")
    @RequestMapping(value = "/sendDelayedMessage", method = RequestMethod.POST)
    public void sendDelayedMessage(@RequestParam("timeout") @ApiParam("过期时间") Long timeout, @RequestBody SubjectDto subjectDto){
        messageQueueSendService.sendDelayMessage(subjectDto,timeout);
    }
}
