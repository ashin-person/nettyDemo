package ljx.ashin.nt.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import ljx.ashin.nt.bean.NTObject;
import ljx.ashin.nt.utils.ByteObjConverter;

/**
 * netty传送中的编码器
 * Created by AshinLiang on 2018/1/8.
 */
public class NTEncoder extends MessageToByteEncoder<NTObject> {
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          NTObject ntObject, ByteBuf byteBuf) throws Exception {
        //工具类：将object转换为byte[]
        byte[] datas = ByteObjConverter.objectToByte(ntObject);
        byteBuf.writeBytes(datas);
        channelHandlerContext.flush();
    }
}
