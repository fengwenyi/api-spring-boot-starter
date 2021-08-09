package com.fengwenyi.apistarter.validator;

import com.fengwenyi.apistarter.constraints.Phone;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-09
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    // 定义的手机号验证正则表达式
    private final Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.hasText(s)) {
            return pattern.matcher(s).matches();
        }

        // 为空，不做校验
        return true;
    }
}
