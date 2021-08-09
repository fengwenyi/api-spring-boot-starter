package com.fengwenyi.apistarter.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-09
 */
public class IdCardNoValidatorUtils {

    // 定义的手机号验证正则表达式
    private static final Pattern pattern = Pattern.compile("^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");

    private static final Integer[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final String[] parity = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    private static final Map<String, String> provMap = new HashMap<String, String>() {{
        put("11", "北京");
        put("12", "天津");
        put("13", "河北");
        put("14", "山西");
        put("15", "内蒙古");
        put("21", "辽宁");
        put("22", "吉林");
        put("23", "黑龙江");
        put("31", "上海");
        put("32", "江苏");
        put("33", "浙江");
        put("34", "安徽");
        put("35", "福建");
        put("36", "江西");
        put("37", "山东");
        put("41", "河南");
        put("42", "湖北");
        put("43", "湖南");
        put("44", "广东");
        put("45", "广西");
        put("46", "海南");
        put("50", "重庆");
        put("51", "四川");
        put("52", "贵州");
        put("53", "云南");
        put("54", "西藏");
        put("61", "陕西");
        put("62", "甘肃");
        put("63", "青海");
        put("64", "宁夏");
        put("65", "新疆");
        put("71", "台湾");
        put("81", "香港");
        put("82", "澳门");
    }};

    public static boolean isValid(String idCardNo) {
        if (!pattern.matcher(idCardNo).matches()) {
            return false;
        }
        if (!checkCode(idCardNo)) {
            return false;
        }
        String date = idCardNo.substring(6, 14);
        if (!checkBirthday(date)) {
            return false;
        }
        return checkProv(idCardNo.substring(0, 2));
    }


    // 校验代码
    private static boolean checkCode(String idCardNo) {
        String code = idCardNo.substring(0, 17);
        String[] split = code.split("");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]) * factor[i];
        }

        return idCardNo.endsWith(parity[sum % 11]);
    }

    // 校验生日
    private static boolean checkBirthday(String birthday) {
        String year = birthday.substring(0, 4);
        String month = birthday.substring(4, 6);
        String date = birthday.substring(6, 8);
        String dateStr = year + "-" + month + "-" + date;
        return checkDateValid(dateStr);
    }

    // 校验省份
    private static boolean checkProv(String s) {
        if (StringUtils.hasText(s)) {
            String value = provMap.get(s);
            return StringUtils.hasText(value);
        }
        return false;
    }

    // 检查日期字符串合法性
    private static boolean checkDateValid(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
