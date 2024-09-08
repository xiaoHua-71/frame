import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 16:23
 **/

public class TestJCL {

    @Test
    public void testQuick() throws Exception {
        // 创建日志对象
        Log log = LogFactory.getLog(TestJCL.class);
        // 日志记录输出
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }
}
