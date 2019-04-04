package GUETWebClient.get;

import GUETWebClient.config.Config;
import GUETWebClient.connUtil.UrlConnUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Form {

    public Map<String, String> setForm(Config config) throws IOException {
        URLConnection urlConn = new UrlConnUtil().urlConn();
        InputStream is = urlConn.getInputStream();
        byte[] by = new byte[10240];
        int len = is.read(by);
        by = Arrays.copyOf(by, len);
        String formText = new String(by);
        is.close();
        Document document = Jsoup.parse(formText);//将获得的含有form的字符串转为Document，如此才能解析里面的表单
        List<Element> elementList = document.select("form");
        Map<String, String> form = new HashMap<>();
        for (int i = 0; i < elementList.size(); i++)
            for (Element element : elementList.get(i).getAllElements()) {
                if (element.attr("name").equals(Config.getUserFormName())) {
                    element.attr("value", config.getUserName());
                }
                if (element.attr("name").equals(Config.getPasswdFormName())) {
                    element.attr("value", config.getPasswd());
                }
                if (element.attr("name").equals(Config.getOtherFormName())) {
                    element.attr("value", "");
                }
                form.put(element.attr("name"), element.attr("value"));
            }
        return form;

    }
}
