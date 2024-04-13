package cn.iocoder.yudao.framework.ai.config;

import cn.iocoder.yudao.framework.ai.chatxinghuo.XingHuoChatModel;
import cn.iocoder.yudao.framework.ai.chatyiyan.YiYanChatModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ai 自动配置
 *
 * @author fansili
 * @time 2024/4/12 16:29
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "yudao.ai")
public class YudaoAiProperties {

    private QianWenProperties qianWen;
    private XingHuoProperties xingHuo;
    private YiYanProperties yiYan;

    @Data
    @Accessors(chain = true)
    public static class ChatProperties {

        private Float temperature;

        private Float topP;

        private Integer topK;
    }

    @Data
    @Accessors(chain = true)
    public static class QianWenProperties extends ChatProperties {
        /**
         * 阿里云：服务器接入点
         */
        private String endpoint = "bailian.cn-beijing.aliyuncs.com";
        /**
         * 阿里云：权限 accessKeyId
         */
        private String accessKeyId;
        /**
         * 阿里云：权限 accessKeySecret
         */
        private String accessKeySecret;
        /**
         * 阿里云：agentKey(相当于应用id)
         */
        private String agentKey;
    }

    @Data
    @Accessors(chain = true)
    public static class XingHuoProperties extends ChatProperties {
        private String appId;
        private String appKey;
        private String secretKey;
        private XingHuoChatModel chatModel;
    }

    @Data
    @Accessors(chain = true)
    public static class YiYanProperties extends ChatProperties {
        /**
         * appKey
         */
        private String appKey;
        /**
         * secretKey
         */
        private String secretKey;
        /**
         * 模型
         */
        private YiYanChatModel chatModel = YiYanChatModel.ERNIE4_3_5_8K;
        /**
         * token 刷新时间(默认 86400 = 24小时)
         */
        private int refreshTokenSecondTime = 86400;
    }
}
