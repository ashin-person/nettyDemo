package ljx.ashin.nt.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import ljx.ashin.nt.bean.NTObject;

/**
 * Created by AshinLiang on 2018/1/8.
 */
public class ServerHandler extends SimpleChannelInboundHandler<NTObject> {
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, NTObject ntObject) throws Exception {
        String content = ntObject.getContent();//内容
        String code = ntObject.getCode();//状态码
        if (code!=null){
            System.out.println("得到客户端的请求信息为:"+content+" 状态码:"+code);
        }else {
            System.out.println("得到客户端的请求信息为:"+content);
        }

        String msg = "服务器端已经接受到您的请求,请求内容为:"+content+"，正在处理中，请稍后";
        NTObject rspObj = new NTObject();
        rspObj.setContent(msg);
        rspObj.setCode("00");//成功
        channelHandlerContext.write(rspObj);
        channelHandlerContext.flush();
    }
}
