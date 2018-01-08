package ljx.ashin.nt.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import ljx.ashin.nt.coder.NTDecoder;
import ljx.ashin.nt.coder.NTEncoder;
import ljx.ashin.nt.handler.ServerHandler;

/**
 * netty的服务器端
 * Created by AshinLiang on 2018/1/8.
 */
public class NettyServer {
    /**
     * 端口
     */
    private int port;

    public NettyServer(int port){
        this.port = port;
        initServer();
    }

    /**
     * 服务器的初始化
     */
    private void initServer(){
        //负责连接客户端的线程池
        EventLoopGroup boss = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors()*2);
        //处理业务逻辑的线程池
        EventLoopGroup worker = new NioEventLoopGroup(1000);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //绑定线程池
        serverBootstrap.group(boss,worker);
        //socket工厂
        serverBootstrap.channel(NioServerSocketChannel.class);
        //设置配置信息
        serverBootstrap.option(ChannelOption.SO_KEEPALIVE,true);//维持链接的活跃
        serverBootstrap.option(ChannelOption.SO_BACKLOG,2048);//连接缓冲池的大小
        serverBootstrap.option(ChannelOption.TCP_NODELAY,true);//不延迟发送

        //设置处理器
        serverBootstrap.childHandler(new ChannelInitializer<Channel>() {
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new NTDecoder());//解码器
                channel.pipeline().addLast(new NTEncoder());//编码器
                channel.pipeline().addLast(new ServerHandler());

            }
        });

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(this.port).sync();//绑定端口
            if (channelFuture.isSuccess()){
                System.out.println("服务器启动成功");
            }
            Thread.sleep(30*60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        NettyServer server = new NettyServer(8765);
        server.initServer();
    }
}
