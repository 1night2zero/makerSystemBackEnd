package zstu.maker_system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zstu.maker_system_backend.entity.User;
import zstu.maker_system_backend.mapper.UserMapper;
import zstu.maker_system_backend.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
