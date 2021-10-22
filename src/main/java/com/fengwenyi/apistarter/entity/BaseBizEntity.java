package com.fengwenyi.apistarter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 业务基础实体类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BaseBizEntity extends BaseEntity {

    private static final long serialVersionUID = 309245880884817022L;

    /**
     * 启用状态
     * @see com.fengwenyi.apistarter.enums.EnabledState
     */
    private Boolean enabledState;

    /**
     * 删除状态
     * @see com.fengwenyi.apistarter.enums.DeleteState
     */
    private Boolean deleteState;

}
