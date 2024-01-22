package com.schoolmanagement.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;



class SmsServiceImplTest {
@BeforeEach
void setUp() {
}

    @Test
    void sendSms() {
        String toNumber = "+918318840872";
        String message = "Hello Bruno!";
        new SmsServiceImpl().sendSms(toNumber,message);
    }

    @Test
    void sendGroupSms() {
        List<String> toNumbers = List.of("+918318840872", "+918318849167");
        String message = "Tomorrow will be holiday on the account of Diwali.";
        new SmsServiceImpl().sendGroupSms(toNumbers,message);
    }

    @Test
    void sendBatchSms() {
        List<String> toNumbers = List.of("+918318840872", "+918318849167");
        List<String> messages = List.of("Hello from SMS 1", "Greetings from SMS to lucky bro");
        new SmsServiceImpl().sendBatchSms(toNumbers, messages);

    }
}