package com.fengwenyi.apistarter.validator;

import com.fengwenyi.apistarter.constraints.IdCardNo;
import com.fengwenyi.apistarter.utils.IdCardNoValidatorUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-09
 */
public class IdCardNoValidator implements ConstraintValidator<IdCardNo, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.hasText(s)) {
            return IdCardNoValidatorUtils.isValid(s);
        }

        // 为空，不做校验
        return true;
    }

}
