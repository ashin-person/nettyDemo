package ljx.ashin.nt.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import ljx.ashin.nt.bean.NTObject;
import ljx.ashin.nt.utils.ByteObjConverter;

import java.util.List;

/**
 * Created by AshinLiang on 2018/1/8.
 */
public class NTDecoder extends ByteToMessageDecoder {
    protected void decode(ChannelHandlerContext channelHandlerContext,
                          ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] content = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(content);

        NTObject ntObject =(NTObject)ByteObjConverter.byteToObject(content);
        list.add(ntObject);
    }
}
