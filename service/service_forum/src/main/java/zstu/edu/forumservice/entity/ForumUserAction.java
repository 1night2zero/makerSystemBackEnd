package zstu.edu.forumservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户操作表（包括收藏和点赞）
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ForumUserAction对象", description="用户操作表（包括收藏和点赞）")
public class ForumUserAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "操作 ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "用户 ID")
    private String userId;

    @ApiModelProperty(value = "帖子 ID")
    private String postId;

    @ApiModelProperty(value = "操作类型：点赞或收藏")
    private String actionType;

    @ApiModelProperty(value = "是否被删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
