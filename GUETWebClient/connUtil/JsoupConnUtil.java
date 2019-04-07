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
            System.out.println("正在检查网络连接状态...    Check Networking");
            connection(Config.getCheckNetUrl()).execute();
            System.out.println("连接正常  Connect to extranet successful ");
            if (key == 0) System.out.println("此时可以按下ctrl+c退出了，也可以继续登录其它账号   You can exit now, or log another account.");
            if (key == 1) System.out.println("登陆成功了  Login compelete.");
        } catch (Exception e) {
            if (key == 0) System.out.println("连接到外网服务器失败，请登录   Connect to extranet failed, please log your account in.");
            else if (key == 1) System.out.println("连接到外网服务器失败，请检查你的账号密码是否正确   Connect to extranet failed, please correct your username and password");

        }
        try {
            System.out.println("状态码   the status code is" + rs.statusCode());
        } catch (NullPointerException e) {

        }
    }
}
