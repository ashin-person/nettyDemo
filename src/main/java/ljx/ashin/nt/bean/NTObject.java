package ljx.ashin.nt.bean;

import java.io.Serializable;

/**
 * netty中传输的实体
 * Created by AshinLiang on 2018/1/8.
 */
public class NTObject implements Serializable{
    /**
     * 传送的内容
     */
    private String content;
    /**
     * 状态码
     */
    private String code;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "NTObject{" +
                "content='" + content + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
