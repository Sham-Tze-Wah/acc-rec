package com.practice.accrec.services;

import com.practice.accrec.utils.AppMessages;
import org.springframework.stereotype.Service;

@Service
public class AppMessagesService {
    public String getAppMessages(String appMessages){
        return appMessages;
    }
}
