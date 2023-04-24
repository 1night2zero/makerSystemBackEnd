package zstu.edu.msmservice.service;

import org.springframework.stereotype.Service;

public interface MsmService {
    boolean send(String phone, String code);

}
