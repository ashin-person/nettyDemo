package ljx.ashin.nt.utils;

import io.netty.buffer.ByteBuf;

import java.io.*;

/**
 * Created by AshinLiang on 2018/1/8.
 */
public class ByteObjConverter {

    /**
     * 将ByteBuf转换为byte[]
     * @param datas
     * @return
     */
    public static byte[] read(ByteBuf datas) {
        byte[] bytes = new byte[datas.readableBytes()];// 创建byte[]
        datas.readBytes(bytes);// 将ByteBuf转换为byte[]
        return bytes;
    }

    /**
     * 使用IO的inputstream流将byte[]转换为object
     * @param bytes
     * @return
     */
    public static Object byteToObject(byte[] bytes){
        Object obj = null;
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream oi = null;
        try {
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 使用IO的outputstream流将object转换为byte[]
     * @return
     */
    public static byte[] objectToByte(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
