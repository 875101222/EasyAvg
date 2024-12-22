package com.easyacg.storage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.easyacg.attribute.entity.IbaAttribute;
import com.easyacg.attribute.model.AttributeValue;
import com.easyacg.attribute.model.define.AttributeValueDefine;
import com.easyacg.core.mybatis.TableBaseDo;
import com.easyacg.image.model.Image;
import com.easyacg.image.model.define.ImageDefine;
import com.easyacg.storage.entity.properties.StorageProperties;
import com.easyacg.storage.entity.properties.StoragePropertiesHandler;
import com.easyacg.storage.model.define.StorageDefine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.autotable.annotation.ColumnComment;
import org.dromara.mpe.autotable.annotation.Column;
import org.dromara.mpe.autotable.annotation.Table;
import org.dromara.mpe.autotable.annotation.UniqueIndex;
import org.dromara.mpe.bind.metadata.annotation.BindEntity;
import org.dromara.mpe.bind.metadata.annotation.JoinCondition;

import java.util.List;

/**
 * 存储策略表
 *
 * @author admin
 */
@Data
@Table
@TableName(autoResultMap = true)
@EqualsAndHashCode(callSuper = true)
public class Storage extends TableBaseDo {
    @UniqueIndex
    @Column(comment = "存储策略名称", notNull = true)
    private String name;

    @ColumnComment("存储策略类型")
    private StorageModeEnum mode;

    @ColumnComment("存储策略配置")
    @Column(comment = "存储策略配置", type = "json")
    @TableField(typeHandler = StoragePropertiesHandler.class)
    private StorageProperties properties;

    @ColumnComment("备注")
    private String remark;

    @BindEntity(conditions = @JoinCondition(selfField = StorageDefine.id, joinField = ImageDefine.storageId))
    private List<Image> imageList;
}
