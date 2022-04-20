package com.vero.ipchecker.service;

import com.vero.ipchecker.domain.UserChecker;
import com.vero.ipchecker.dtos.IpRequest;
import com.vero.ipchecker.repository.IpCheckerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCheckerServiceImpl implements UserCheckerService {
    private final IpCheckerRepository ipCheckerRepository;


    @Override
    public void whitelistIP(IpRequest request) {
        try {
            Optional<UserChecker> ipAddress = ipCheckerRepository.findUserCheckerByIpAddress(request.getIpAddress());
            if (!ipAddress.isPresent()) {
                UserChecker newIP = new UserChecker();
                newIP.setIpAddress(request.getIpAddress());
                StartService.allowedIPs.put(request.getIpAddress(), request.getIpAddress());
                ipCheckerRepository.save(newIP);
            } else {
                throw new EntityExistsException("IP already whitelisted");
            }
        } catch (Exception e) {
            throw new EntityExistsException("IP already whitelisted");
        }

    }

    @Override
    public void blacklistIP(IpRequest request) {
        try {
            Optional<UserChecker> ipAddress = ipCheckerRepository.findUserCheckerByIpAddress(request.getIpAddress());
            if (ipAddress.isPresent()) {
                StartService.allowedIPs.remove(ipAddress.get().getIpAddress());
                ipCheckerRepository.delete(ipAddress.get());
            }
            throw new EntityExistsException("IP not whitelisted");

        } catch (Exception e) {

        }

    }
}

