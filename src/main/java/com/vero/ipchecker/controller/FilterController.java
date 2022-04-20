package com.vero.ipchecker.controller;

import com.vero.ipchecker.dtos.IpRequest;
import com.vero.ipchecker.service.UserCheckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class FilterController {
    private final UserCheckerService userCheckerService;


    @RequestMapping(value = { "/check-IP" })
    public ResponseEntity<String> checkIp() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = { "/secure-code/public" })
    public String pubCode() {

        return "2@CLASG$(%23";
    }

    @PostMapping("/whitelist")
    public  ResponseEntity<?> whitelistIP(@RequestBody IpRequest request){
            userCheckerService.whitelistIP(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/blacklist")
    public  ResponseEntity<?> blacklist(@RequestBody IpRequest request){
        userCheckerService.blacklistIP(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = { "/auth-failed"})
    public ResponseEntity<String> authFailed()
    {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


}