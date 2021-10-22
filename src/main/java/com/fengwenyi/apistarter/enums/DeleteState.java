package com.fengwenyi.apistarter.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-23
 */
@Getter
public enum DeleteState {

    YES(Boolean.TRUE, "删除")
    , NO(Boolean.FALSE, "不删除")

    ;

    private final boolean code;

    private final String desc;

    DeleteState(boolean code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
