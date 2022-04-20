package com.vero.ipchecker.service;
import com.vero.ipchecker.dtos.IpRequest;

public interface UserCheckerService{
     void whitelistIP(IpRequest request);
     void blacklistIP(IpRequest request);
}
