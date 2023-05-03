package API01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ author Egcoo
 * @ date 2022/10/2 - 9:49
 */
public class apiRemake01 {
    public static void main(String[] args) throws UnknownHostException {

        //1.获取本机的 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-URL579CL/10.65.249.141

        // 2.根据主机名获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-URL579CL");
        System.out.println(host1);

        // 3.根据域名返回 InetAddress对象，比如 www.baidu.com
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        // 4.通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);

        // 5.通过对象，获取主机名/域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}
