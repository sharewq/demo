package com.Commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取客户端网络信息(局域网)
 * Created by Think on 2017/11/27.
 */
public class HttpClientUtils {

    private static String MAC_CHEN_HONG_BO = "f4-8e-38-8a-c6-02";      //陈红波
    private static String MAC_ZHOU_SHONG = "f4-8e-38-8a-c6-02";

    public static void main(String[] args) {
        //getLanIps();
        getIpByPhysAddr(HttpClientUtils.MAC_CHEN_HONG_BO);

       /* List<String> ips = new ArrayList<>();
        ips.add("192.168.2.147");
        ips.add("192.168.2.212");
        Map<String, String> map = getHostnames(ips);*/
    }

    /**
     * 获取物理地址对应IP
     *
     * @param physAddr
     * @return
     */
    public static List<String> getIpByPhysAddr(String physAddr) {
        if (StringUtils.isNullOrEmpty(physAddr)) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Map<String, String> map = getLanIps();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (physAddr.equals(entry.getKey())) {
                System.out.println("Mac = " + entry.getKey() + " : IP = " + entry.getValue());
                list.add(entry.getValue());
            }
        }
        return list;
    }

    /**
     * 获取局域网--IP
     *
     * @return
     */
    public static Map<String, String> getLanIps() {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        int count = 0;
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec("arp -a");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
            String inline;
            while ((inline = br.readLine()) != null) {
                if (inline.indexOf("接口") > -1) {
                    flag = true;
                    count = 0;
                }
                if (flag) {
                    count++;
                    if (count > 2) { //有效IP
                        String[] str = inline.split(" {4}");
                        if (str.length >= 2) {
                            map.put(str[2].trim(), str[0].trim());
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据IP提取主机名
     *
     * @param ips
     * @return
     */
    public static Map<String, String> getHostnames(List<String> ips) {

        Map<String, String> map = new HashMap<String, String>();
        for (String ip : ips) {
            String command = "ping -a " + ip;
            Runtime r = Runtime.getRuntime();
            Process p;
            try {
                p = r.exec(command);
                BufferedReader br = new BufferedReader(new InputStreamReader(p
                        .getInputStream()));
                String inline;
                while ((inline = br.readLine()) != null) {
                    if (inline.indexOf("[") > -1) {
                        int start = inline.indexOf("Ping ");
                        int end = inline.indexOf("[");
                        String hostname = inline.substring(start + "Ping ".length(), end - 1);
                        System.out.println("IP:" + ip + "  hostname:" + hostname);
                        map.put(ip, hostname);
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
