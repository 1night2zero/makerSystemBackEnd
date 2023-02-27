package zstu.maker_system_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zstu.maker_system_backend.mapper")
public class MakerSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakerSystemBackendApplication.class, args);
    }

}
