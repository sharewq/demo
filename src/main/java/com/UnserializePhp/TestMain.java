package com.UnserializePhp;

import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 反序列化 php 序列化的对象
 * Created by Think on 2017/12/23.
 */
public class TestMain {

    public static void main(String[] args) {
        String str = "a:6:{i:0;a:5:{s:3:\"key\";s:3:\"263\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:119:\"《出生医学证明》（无《出生医学证明》的提供县级以上公证机关亲子关系证明）（原件) \";s:6:\"isNeed\";s:1:\"1\";s:5:\"value\";s:52:\"#@#./upload/weixin/20160927/201609271413291040.jpg\n" +
                " \";}i:1;a:5:{s:3:\"key\";s:3:\"264\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:35:\"父母双方的结婚证（原件) \";s:6:\"isNeed\";s:1:\"1\";s:5:\"value\";s:104:\"#@#./upload/weixin/20160927/201609271413385651.jpg\n" +
                " #@#./upload/weixin/20160927/201609271413409568.jpg\n" +
                " \";}i:2;a:5:{s:3:\"key\";s:3:\"265\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:40:\"父母双方居民户口簿（原件） \";s:6:\"isNeed\";s:1:\"1\";s:5:\"value\";s:104:\"#@#./upload/weixin/20160927/201609271413553788.jpg\n" +
                " #@#./upload/weixin/20160927/201609271413574025.jpg\n" +
                " \";}i:3;a:5:{s:3:\"key\";s:3:\"266\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:38:\"父母双方居民身份证（原件) \";s:6:\"isNeed\";s:1:\"1\";s:5:\"value\";s:104:\"#@#./upload/weixin/20160927/201609271414128994.jpg\n" +
                " #@#./upload/weixin/20160927/201609271414147459.jpg\n" +
                " \";}i:4;a:5:{s:3:\"key\";s:3:\"267\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:223:\"《成都市符合法律法规生育通知单》（出生后应先到街道办事处计划生育办公室作出生统计后，再申报户口）或征收社会抚养费决定书和缴纳社会抚养费的凭据（原件） \";s:6:\"isNeed\";s:1:\"1\";s:5:\"value\";s:52:\"#@#./upload/weixin/20160927/201609271414231456.jpg\n" +
                " \";}i:5;a:5:{s:3:\"key\";s:3:\"268\";s:4:\"type\";s:1:\"1\";s:4:\"name\";s:14:\"其他材料  \";s:6:\"isNeed\";s:1:\"2\";s:5:\"value\";s:0:\"\";}}";

        try {
            List<Test> list = getUnserializeList(str);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 若是单个对象，直接可以反序列化
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static Test getUnserialize(String content) throws Exception {
        PHPSerializer p = new PHPSerializer();
        if (StringUtils.isEmpty(content))
            return null;
        Test t = (Test) p.unserialize(content.getBytes(), Test.class);
        return t;
    }

    /**
     * 若是array需要借助Cast类，转换成java对应的对象
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static List<Test> getUnserializeList(String content) throws Exception {
        List<Test> list = new ArrayList<Test>();
        PHPSerializer p = new PHPSerializer();
        if (StringUtils.isEmpty(content))
            return list;
        AssocArray array = (AssocArray) p.unserialize(content.getBytes());
        for (int i = 0; i < array.size(); i++) {
            Test t = (Test) Cast.cast(array.get(i), Test.class);
            list.add(t);
        }
        return list;
    }
}
