package com.fengwenyi.apistarter.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-02
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2483157007230468308L;

    /**
     * ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDateTime;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建者名字
     */
    private String createUserName;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateDateTime;

    /**
     * 更新者ID
     */
    private Long updateUserId;

    /**
     * 更新者名字
     */
    private String updateUserName;

}
