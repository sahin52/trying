package com.sahins.trying;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
@RestController
@RequestMapping("/mesaj")
/*https://api.ibb.gov.tr/ispark/ParkDetay?id=395*/
public class MerhabaApi {
    public JSONArray HttpGetRequestToJsonArray(String url) throws MalformedURLException, IOException, JSONException {
        JSONArray res;
        URL u;
        StringBuffer sb;


        u = new URL(url);
        HttpURLConnection connection;
        connection = (HttpURLConnection) u.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String in;
        sb = new StringBuffer();
        while((in=bufferedReader.readLine())!=null){
            sb.append(in);
        }
        System.out.println(sb.toString());
        res = new JSONArray(sb.toString());
        connection.disconnect();
        return res;
    }
    public String handlerr() throws IOException, JSONException {
        JSONArray parks = HttpGetRequestToJsonArray("https://api.ibb.gov.tr/ispark/Park");
        List<String> list = null;
        String res = null;
        return "something ";
        /*for (int i = 0; i < parks.length(); i++) {
            list.add(parks.getJSONObject(i).getString("Ilce"));
            return "list.get(0)";
        }
        for(int i=0;i<list.size();i++){
            res.concat(list.get(i));
        }
        return res;*/
    }
    @GetMapping
    public String merhaba() throws IOException, JSONException {
        return handlerr();
    }
}
