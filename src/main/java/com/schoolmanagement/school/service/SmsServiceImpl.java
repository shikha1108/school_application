package com.schoolmanagement.school.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    private String ACCOUNT_SID = "AC4830443585a2a639aa3f4fef61deed24";

    private String AUTH_TOKEN = "efe278497fd86dab237139f77d862e04";

    @Override
    public void sendSms(String toNumber, String message) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message messageToSend = Message.creator(
                    new com.twilio.type.PhoneNumber(toNumber),
                    new com.twilio.type.PhoneNumber("+12482366326"),
                    message).create();
            System.out.println(messageToSend.getSid());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send SMS");
        }
    }

    @Override
    public void sendGroupSms(List<String> toNumbers, String message) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            for (String toNumber : toNumbers) {
                Message messageToSend = Message.creator(
                        new com.twilio.type.PhoneNumber(toNumber),
                        new com.twilio.type.PhoneNumber("+12482366326"),
                        message).create();
                System.out.println(messageToSend.getSid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send SMS");
        }
    }

    @Override
    public void sendBatchSms(List<String> toNumbers, List<String> messages) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

//            if (toNumbers.size() != messages.size()) {
//                throw new IllegalArgumentException("Number of toNumbers must be equal to the number of messages");
//            }

            for (int i = 0; i < toNumbers.size(); i++) {
                String toNumber = toNumbers.get(i);
                String message = messages.get(i);

                Message messageToSend = Message.creator(
                        new com.twilio.type.PhoneNumber(toNumber),
                        new com.twilio.type.PhoneNumber("+12482366326"),
                        message).create();
                System.out.println(messageToSend.getSid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send SMS");
        }

    }
}

