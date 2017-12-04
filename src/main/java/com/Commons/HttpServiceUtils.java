package com.Commons;

import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

/**
 * 获取本机网络信息
 * Created by Think on 2017/11/2.
 */
public class HttpServiceUtils {

    public static void main(String[] args) {
        InetAddress netAddress = getInetAddress();
        System.out.println("host ip: " + getHostIp(netAddress));
        System.out.println("host name: " + getHostName(netAddress));
        System.out.println("host system name: " + getHostSystemName());
        System.out.println("host system type: " + getHostSystemType());

        Properties properties = System.getProperties();
        Set<String> set = properties.stringPropertyNames(); //获取java虚拟机和系统的信息。

        System.out.println("****************** 获取java虚拟机和系统的信息 ********************");
        for (String name : set) {
            System.out.println(name + ":" + properties.getProperty(name));
        }
        System.out.println("****************** 获取java虚拟机和系统的信息 ********************");

    }

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("unknown host! UnknownHostException =  " + e);
        }
        return null;
    }

    /**
     * 获取 IP
     *
     * @param netAddress
     * @return
     */
    public static String getHostIp(InetAddress netAddress) {
        return StringUtils.isEmpty(netAddress) ? null : netAddress.getHostAddress();
    }

    /**
     * 获取主机名称
     *
     * @param netAddress
     * @return
     */
    public static String getHostName(InetAddress netAddress) {
        return StringUtils.isEmpty(netAddress) ? null : netAddress.getHostName();
    }

    /**
     * 获取主机系统名称
     *
     * @return
     */
    public static String getHostSystemName() {
        return System.getProperty("user.name");
    }

    /**
     * 获取主机系统类别
     *
     * @return
     */
    public static String getHostSystemType() {
        return System.getProperty("os.name").toLowerCase();
    }

}
