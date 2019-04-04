package GUETWebClient.connUtil;

import GUETWebClient.config.Config;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnUtil {
    public URLConnection urlConn() throws IOException {
        URLConnection url = new URL(Config.getFormUrl()).openConnection();
        url.setRequestProperty("UserAgent", Config.getUserAgent());
        url.setRequestProperty("Connection", Config.getConnection());
        url.setReadTimeout(10000);
        return url;
    }

    public UrlConnUtil(){
        try {
            urlConn().connect();
        } catch (SocketException e) {
            System.out.println("网络异常，请检查好配置，如ip地址不能为静态ip");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
