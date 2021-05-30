package Lesson10.Task2;

import Lesson10.Task2.model.DictResult;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YandexUitl {

    public static final String APIKEY = "dict.1.1.20210211T055620Z.b9224d2d2e06bf28.54f70de7ea38d8ffe612193daf11ad76cea4ee03";


    public static String[] getLangs() throws IOException {


        HttpGet httpGet = new HttpGet("https://dictionary.yandex.net/api/v1/dicservice.json/getLangs?key=" + APIKEY);
        HttpClient httpClient = HttpClients.createDefault();

        HttpResponse response = httpClient.execute(httpGet);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        Gson gson = new Gson();

        String[] result = gson.fromJson(bufferedReader, String[].class);
        System.out.println(Arrays.toString(result));

        return result;
    }

    public static DictResult lookUp(String lang, String text) throws IOException {
        HttpGet httpGet = new HttpGet("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" +
                APIKEY + "&lang=" + lang + "&text=" + text);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);


        System.out.println(response);
        System.out.println(response.getEntity().getContent());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        Gson gson = new Gson();

        DictResult result = gson.fromJson(bufferedReader, DictResult.class);
        System.out.println(result);

        return result;
    }
}
