package ljx.ashin.nt.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import ljx.ashin.nt.bean.NTObject;

/**
 * Created by AshinLiang on 2018/1/8.
 */
public class ClientHandler extends SimpleChannelInboundHandler<NTObject> {
    protected void messageReceived(ChannelHandlerContext channelHandlerContext,
                                   NTObject ntObject) throws Exception {
        System.out.println("得到的信息为:"+ntObject.getContent());
    }
}
