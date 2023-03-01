package zstu.edu.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("zstu.edu.eduservice.mapper")
public class EduConfig {

}
