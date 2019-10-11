package net.chachy.modutils.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpUtils {
    public static String get(String url) throws IOException {
        URL u = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection)u.openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String out = br.lines().collect(Collectors.joining());
        br.close();
        return out;
    }

}
