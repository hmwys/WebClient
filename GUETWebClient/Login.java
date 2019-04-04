package GUETWebClient;

import GUETWebClient.login.LoginUtil;

import java.io.IOException;

public class Login {
    public static void main(String[] args) throws IOException {
        System.out.println("注意，该程序并不是出校器，它只能于登录网页校园网认证界面");
        new LoginUtil().login();
    }
}
