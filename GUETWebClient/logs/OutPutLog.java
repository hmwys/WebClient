package GUETWebClient.logs;

import org.jsoup.Connection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutLog {


    public void outputPage(Connection.Response rs) throws IOException {
        File page = new File("./log/", "returnPage.txt");
        if (!page.exists()) new File("./log").mkdir();
        FileOutputStream fos = new FileOutputStream(page);
        fos.write(rs.bodyAsBytes());
        fos.close();
    }

    public void outputCookie(Connection.Response rs) throws IOException {
        File cookies = new File("./log/", "cookies.txt");
        if (!cookies.exists()) new File("./log").mkdir();
        FileOutputStream fos = new FileOutputStream(cookies);
        fos.write(rs.cookies().toString().getBytes());
        fos.close();
    }
}
