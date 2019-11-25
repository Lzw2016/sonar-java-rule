package com.jzt.sonar.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 09:37 <br/>
 */
public class CameCaseUtils {
    /**
     * 全大写驼峰规则 <br />
     * "^I?([A-Z][a-z0-9]+)+(([A-Z])|(DO|DTO|VO|DAO|BO|DAOImpl|YunOS|AO|PO))?$"
     */
    private static final Pattern UPPER_PATTERN = Pattern.compile("^I?([A-Z][a-z0-9]+)+([A-Z])?$");

    /**
     * 首字母小写驼峰规则 <br />
     * "^[a-z|$][a-z0-9]*([A-Z][a-z0-9]*)*(DO|DTO|VO|DAO)?$"
     */
    private static final Pattern LOWER_PATTERN = Pattern.compile("^[a-z|$][a-z0-9]*([A-Z][a-z0-9]+)*([A-Z])?$");

    /**
     * 全大写
     */
    private static final Pattern ALL_UPPER = Pattern.compile("^[A-Z|$][A-Z0-9|_]*$");

    /**
     * 校验标准驼峰规则(全大写)
     */
    public static boolean checkUpperCameCase(String name) {
        if (StringUtils.isBlank(name)) {
            return true;
        }
        return UPPER_PATTERN.matcher(name).matches();
    }

    /**
     * 校验标准驼峰规则(首字母小写)
     */
    public static boolean checkLowerCameCase(String name) {
        if (StringUtils.isBlank(name)) {
            return true;
        }
        return LOWER_PATTERN.matcher(name).matches();
    }

    public static boolean checkAllUpper(String name) {
        if (StringUtils.isBlank(name)) {
            return true;
        }
        return ALL_UPPER.matcher(name).matches();
    }
}
