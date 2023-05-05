package zstu.edu.servicebase.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("基础实体")
public class BaseEntity<T extends Serializable> implements Serializable {

//    @ApiModelProperty(
//            value = "创建者ID",
//            position = 101
//    )
//    @TableField(
//            fill = FieldFill.INSERT
//    )
//    private T creatorId;

    @ApiModelProperty(
            value = "创建时间",
            position = 102
    )

    @TableField(
            fill = FieldFill.INSERT
    )
    private Date gmtCreate;
//    @ApiModelProperty(
//            value = "修改者ID",
//            position = 103
//    )
//    @TableField(
//            fill = FieldFill.INSERT_UPDATE
//    )
//    private T modifierId;

    @ApiModelProperty(
            value = "修改时间",
            position = 104
    )
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private Date gmtModified;

    public BaseEntity() {
    }



    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return this.gmtModified;
    }

    public void setGmtModify(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String toString() {
        return "BaseEntity(" + " gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModify() + ")";
    }

}
