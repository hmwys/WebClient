package GUETWebClient.connUtil;

import GUETWebClient.config.Config;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.net.SocketException;

public class JsoupConnUtil {
    public Connection connection(String url) {
        org.jsoup.Connection jconnection = Jsoup.connect(url);
        jconnection.header("UserAgent", Config.getUserAgent());
        jconnection.followRedirects(true);
        jconnection.header("Connection", Config.getConnection());
        return jconnection;
    }

    public void checkConn(int key) {
        Connection.Response rs = null;
        try {
            System.out.println("正在检查网络连接状态...");
            connection(Config.getCheckNetUrl()).execute();
            System.out.println("连接正常");
            if (key == 0) System.out.println("此时可以按下ctrl+c退出了，也可以继续登录其它账号");
            if (key == 1) System.out.println("登陆成功了");
        } catch (Exception e) {
            if (key == 0) System.out.println("连接到外网服务器失败，请登录");
            else if (key == 1) System.out.println("连接到外网服务器失败，请检查你的账号密码是否正确");

        }
        try {
            System.out.println("状态码" + rs.statusCode());
        } catch (NullPointerException e) {

        }
    }
}
