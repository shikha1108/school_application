package com.schoolmanagement.school.service;

import java.util.List;

public interface SmsService {
    void sendSms(String toNumber, String message);
    void sendGroupSms(List<String> toNumber, String message);
    void sendBatchSms(List<String> toNumber, List<String> message);

}
