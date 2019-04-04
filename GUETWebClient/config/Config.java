package GUETWebClient.config;

public class Config {
    private static String LoginUrl = "http://10.32.254.11/a70.htm";
    private static String logoutUrl = "http://10.32.254.11/F.htm";
    private static String formUrl = "http://10.32.254.11:801/eportal/extern/huajiang_2018041101/ip/3/pc.js";
    private static String checkNetUrl = "https://www.baidu.com";
    private static String UserAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";
    private static String Connection = "keep-alive";
    private static String UserFormName="DDDDD";
    private static String PasswdFormName="upass";
    private static String OtherFormName="R2";
    private  String userName = "";
    private  String passwd = "";

    public static String getFormUrl() {
        return formUrl;
    }

    public static String getCheckNetUrl() {
        return checkNetUrl;
    }

    public static String getLoginUrl() {
        return LoginUrl;
    }

    public static String getLogoutUrl() {
        return logoutUrl;
    }

    public static String getUserAgent() {
        return UserAgent;
    }

    public static String getConnection() {
        return Connection;
    }

    public static String getUserFormName() {
        return UserFormName;
    }

    public static String getPasswdFormName() {
        return PasswdFormName;
    }

    public static String getOtherFormName() {
        return OtherFormName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
