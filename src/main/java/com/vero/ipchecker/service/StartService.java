package com.vero.ipchecker.service;

import com.vero.ipchecker.IpCheckerApplication;
import com.vero.ipchecker.domain.UserChecker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
@Slf4j
@EnableScheduling
@RequiredArgsConstructor
public class StartService {
   public static final HashMap<String,String> allowedIPs = new HashMap<>();


   // @Scheduled(cron = "* 00 2 * * * ",zone = "Africa/Lagos")
//    @Scheduled(fixedDelayString ="86400000")
   @PostConstruct
    private void ipInitializer(){

        UserChecker userChecker = new UserChecker();
        userChecker.setId(1L);
        userChecker.setIpAddress("182.0.2.111");

    allowedIPs.put(userChecker.getIpAddress(),"This Ip");

        String j = allowedIPs.get("182.0.2.111");

       System.out.println(allowedIPs.get("182.0.2.111")+ " is the IP");


    }



}
