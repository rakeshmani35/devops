package com.javatechie.aws.sns.controller;

import com.javatechie.aws.sns.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sns")
public class SnsController {

    @Autowired
    private SnsService snsService;

    @GetMapping("/subscribe")
    public String enableSubscription(@RequestParam String protocol, @RequestParam String endpoint) {
        return snsService.autoSubscription(protocol, endpoint);
    }

    @PostMapping
    public String publishMessageToTopic(@RequestBody String message) {
        return snsService.publishMessage(message);
    }

    private String buildEmailBody(){
        return "Dear Employee ,\n" +
                "\n" +
                "\n" +
                "Connection down Bangalore."+"\n"+
                "All the servers in Bangalore Data center are not accessible. We are working on it ! \n" +
                "Notification will be sent out as soon as the issue is resolved. For any questions regarding this message please feel free to contact IT Service Support team";
    }

}
