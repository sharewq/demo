package com.Commons;

import com.Redis.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * 序列化/反序列化工具
 * Created by Think on 2017/11/2.
 */
public class SerializeUtils {
    private static final Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    public static void main(String[] args) {
        //User
        User p = new User();  //peson类记得实现序列化接口 Serializable
        p.setPassword("密码忘记了1025");
        p.setName("王强");
        p.setId("1025");

        serializeToJsonFile(User.class, p);
        User user = unserizlizeToJsonFile(User.class);
        logger.info("name = " + user.getName() + " password = " + user.getPassword());
    }


    /**
     * 序列化-byte
     *
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            return bai.toByteArray();
        } catch (IOException e) {
            logger.error("对象序列化二进制异常，Exception : " + e);
        }
        return null;
    }

    /**
     * 反序列化-Object
     *
     * @param byt
     * @return
     */
    public static Object unserizlize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        try {
            bis = new ByteArrayInputStream(byt);
            oii = new ObjectInputStream(bis);
            return oii.readObject();
        } catch (Exception e) {
            logger.error("二进制反序列化对象异常，Exception : " + e);
        }
        return null;
    }


    /**
     * 序列化-XML-File
     *
     * @param clazz
     * @param obj
     * @param <T>
     */
    public static <T> void serializeToXmlFile(Class<T> clazz, Object obj) {
        FileOutputStream foStream = null;
        XStream xStream = null;
        try {
            foStream = new FileOutputStream("E:\\" + clazz.getSimpleName() + ".xml");
            xStream = new XStream();
            xStream.alias(clazz.getSimpleName(), obj.getClass());
            xStream.toXML(obj, foStream);
        } catch (Exception e) {
            logger.error("对象序列化为 XML-File 异常，Exception : " + e);
        }
    }

    /**
     * 反序列化-XML
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T unserizlizeToXmlFile(Class<T> clazz) {
        FileInputStream flStream = null;
        XStream xStream = null;
        try {
            xStream = new XStream();
            xStream.alias(clazz.getSimpleName(), clazz);
            flStream = new FileInputStream("E:\\" + clazz.getSimpleName() + ".xml");
            return (T) xStream.fromXML(flStream);
        } catch (Exception e) {
            logger.error("XML-File 序列化为对象异常，Exception : " + e);
        }
        return null;
    }

    /**
     * 序列化-XML
     *
     * @param obj
     * @return
     */
    public static <T> String serializeToXml(T obj) {
        ByteArrayOutputStream out = null;
        XMLEncoder encoder = null;
        try {
            out = new ByteArrayOutputStream();
            encoder = new XMLEncoder(new BufferedOutputStream(out));
            encoder.writeObject(obj);
            encoder.close();
            return out.toString();
        } catch (Exception e) {
            logger.error("对象序列化XML异常，Exception : " + e);
        }
        return null;
    }

    /**
     * 反序列化-XML
     *
     * @param xml
     * @param <T>
     * @return
     */
    public static <T> T unserizlizeToXml(String xml) {
        ByteArrayInputStream in = null;
        XMLDecoder decoder = null;
        try {
            in = new ByteArrayInputStream(xml.getBytes());
            decoder = new XMLDecoder(new BufferedInputStream(in));
            decoder.close();
            return (T) decoder.readObject();
        } catch (Exception e) {
            logger.error("XML反序列化对象异常，Exception : " + e);
        }
        return null;
    }

    /**
     * JSON
     * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
     * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
     * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
     * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
     * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
     * <p>
     * 序列化-JSON-File
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
     *
     * @param obj
     */
    public static <T> void serializeToJsonFile(Class<T> clazz, Object obj) {
        ObjectMapper mapper = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\" + clazz.getSimpleName() + ".js");
            mapper = new ObjectMapper();
            mapper.writeValue(fos, obj);
        } catch (Exception e) {
            logger.error("对象序列化JSON-File 异常，Exception : " + e);
        }
    }

    /**
     * 反序列化-JSON
     *
     * @param clazz
     * @param <T>
     */
    public static <T> T unserizlizeToJsonFile(Class<T> clazz) {
        ObjectMapper mapper = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\" + clazz.getSimpleName() + ".js");
            mapper = new ObjectMapper();
            return (T) mapper.readValue(fis, clazz);
        } catch (Exception e) {
            logger.error("对象序列化JSON异常，Exception : " + e);
        }
        return null;
    }

    /**
     * 序列化-JSON
     *
     * @param obj
     */
    public static <T> String unserizlizeToJson(Object obj) {
        ObjectMapper mapper = null;
        try {
            mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("对象序列化JSON异常，Exception : " + e);
        }
        return null;
    }

    /**
     * 反序列化-JSON
     *
     * @param json
     */
    public static <T> T unserizlizeToJson(Class<T> clazz, String json) {
        ObjectMapper mapper = null;
        try {
            mapper = new ObjectMapper();
            return (T) mapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("对象序列化JSON异常，Exception : " + e);
        }
        return null;
    }

}
