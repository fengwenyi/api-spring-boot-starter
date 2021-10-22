package com.fengwenyi.apistarter.enums;

import lombok.Getter;

/**
 * 启用状态枚举
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-23
 */
@Getter
public enum EnabledState {

    YES(Boolean.TRUE, "启用")
    , NO(Boolean.FALSE, "不启用")

    ;

    private final boolean code;

    private final String desc;

    EnabledState(boolean code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
