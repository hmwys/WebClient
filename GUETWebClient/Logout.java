package GUETWebClient;

import GUETWebClient.login.LoginUtil;

import java.io.IOException;

public class Logout {
    public static void main(String[] args) throws IOException {
        new LoginUtil().logout();
    }
}
