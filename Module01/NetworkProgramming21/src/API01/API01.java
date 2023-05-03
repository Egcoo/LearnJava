package API01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ author Egcoo
 * @ date 2022/7/29 - 10:57
 * 演示InetAddress 类的使用
 */
public class API01 {
    public static void main(String[] args) throws UnknownHostException {

        //1.获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); //LAPTOP-URL579CL/192.168.101.14

        //2.根据主机名，货物 InetAddress 对象
        InetAddress byName = InetAddress.getByName("LAPTOP-URL579CL");
        System.out.println(byName);

        //3.根据域名，返回 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("www.baidu.com");
        System.out.println(host1);

        //4.通过 InetAddress 对象，获取对应地址
        String host2 = host1.getHostAddress();
        System.out.println(host2);

        //4.通过 InetAddress 对象，获取对应域名/主机名
        String host3 = host1.getHostName();
        System.out.println(host3);
    }
}
