package com.schoolmanagement.school.controller;

import com.schoolmanagement.school.request.SmsBatchRequest;
import com.schoolmanagement.school.request.SmsGroupRequest;
import com.schoolmanagement.school.request.SmsRequest;
import com.schoolmanagement.school.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SmsController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/sendsms")
    public ResponseEntity<String> sendSMS(@Validated @RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.toNumber, smsRequest.msg);
        System.out.println("my name is" + Thread.currentThread().getName());
        return ResponseEntity.ok("sms sent successfully");
    }

    @PostMapping("/groupsms")
    public ResponseEntity<String> sendGroupSms(@Validated @RequestBody SmsGroupRequest groupRequest) {
        smsService.sendGroupSms(groupRequest.toNumbers, groupRequest.msg);
        return ResponseEntity.ok("group sms sent successfully");
    }

    @PostMapping("/multiplesms")
    public ResponseEntity<String> sendBatchSms(@Validated @RequestBody SmsBatchRequest smsBatchRequest) {
        smsService.sendBatchSms(smsBatchRequest.toNumbers, smsBatchRequest.messages);
        return ResponseEntity.ok("Batch SMS sent successfully");
    }


}


