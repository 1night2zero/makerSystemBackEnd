package zstu.maker_system_backend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    // 逻辑删除
    private Integer deleted;
}
