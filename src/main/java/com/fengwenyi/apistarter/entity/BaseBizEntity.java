package com.fengwenyi.apistarter.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BaseBizEntity extends BaseEntity {

    private Boolean releaseStatus;

    private Boolean deleteStatus;

}
