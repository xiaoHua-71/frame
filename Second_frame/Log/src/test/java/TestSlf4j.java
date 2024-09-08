
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Test;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-25 18:25
 **/

public class TestSlf4j {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(TestSlf4j.class);
    @Test
    public void testSlf4j(){

        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 使用占位符输出日志信息
        String name = "lucy";
        Integer age = 18;
        LOGGER.info("{}今年{}岁了！", name, age);
        // 将系统异常信息写入日志
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // e.printStackTrace();
            LOGGER.info("出现异常：", e);
        }

    }


}
