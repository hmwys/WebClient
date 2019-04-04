package GUETWebClient.login;

import GUETWebClient.config.Config;
import GUETWebClient.connUtil.JsoupConnUtil;
import GUETWebClient.get.Form;
import GUETWebClient.logs.OutPutLog;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class LoginUtil {
    int key = 0;
    Config config = new Config();

    public void login() throws IOException {
        new JsoupConnUtil().checkConn(key);
        key = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID:");
        config.setUserName(scanner.next());
        System.out.print("Password:");
        config.setPasswd(scanner.next());
        Map<String, String> form = new Form().setForm(config);
        Connection conn = new JsoupConnUtil().connection(Config.getLoginUrl());

        Response rs = conn.method(Connection.Method.GET).execute();
        Response loginRs = conn.method(Method.POST).data(form).cookies(rs.cookies()).execute();

        new OutPutLog().outputPage(loginRs);
        new OutPutLog().outputCookie(rs);
        System.out.println("cookie等信息已输出在log文件夹下");

        new JsoupConnUtil().checkConn(key);


    }

    public void logout() throws IOException {

        Connection conn = new JsoupConnUtil().connection(Config.getLogoutUrl());
        conn.execute();
        System.out.println("已登出");
    }


}
