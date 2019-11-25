package com.jzt.sonar.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 09:43 <br/>
 */
@Slf4j
public class CameCaseUtilsTest {

    @Test
    public void t1() {
        log.info("### --> {}", CameCaseUtils.checkUpperCameCase("CheckUpperCameCase"));
        log.info("### --> {}", CameCaseUtils.checkUpperCameCase("ICheckUpperCameCase"));
        log.info("### --> {}", CameCaseUtils.checkUpperCameCase("CheckUpperCameCaseA"));
        log.info("### --> {}", CameCaseUtils.checkUpperCameCase("CheckUpperCameCaseAA"));
        log.info("### --> {}", CameCaseUtils.checkUpperCameCase("CheckUpperCameCaseAAaaa"));
    }

    @Test
    public void t2() {
        log.info("### --> {}", CameCaseUtils.checkLowerCameCase("checkUpperCameCase"));
        log.info("### --> {}", CameCaseUtils.checkLowerCameCase("iCheckUpperCameCase"));
        log.info("### --> {}", CameCaseUtils.checkLowerCameCase("checkUpperCameCaseA"));
        log.info("### --> {}", CameCaseUtils.checkLowerCameCase("checkUpperCameCaseAA"));
        log.info("### --> {}", CameCaseUtils.checkLowerCameCase("checkUpperCameCaseAAaaa"));
    }

    @Test
    public void t3() {
        log.info("### --> {}", CameCaseUtils.checkAllUpper("CHECK_UPPER_CAME_CASE"));
        log.info("### --> {}", CameCaseUtils.checkAllUpper("I_CHECK_UPPER_CAME_CASE"));
        log.info("### --> {}", CameCaseUtils.checkAllUpper("CHECK_UPPER_CAME_CASE_A"));
        log.info("### --> {}", CameCaseUtils.checkAllUpper("CHECK_UPPER_CAME_CASE_AA"));
        log.info("### --> {}", CameCaseUtils.checkAllUpper("CHECK_UPPER_CAME_CASE_A_AAAAAa"));
    }
}
