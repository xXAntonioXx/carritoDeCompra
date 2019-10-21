package com.example.carritodecompra;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class data {

    public List<AllItemsArray> getItemsGet() {
        return itemsGet;
    }

    public List<AllItemsArray> itemsGet;

    public void getItems(String url) {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    itemsGet = CONTRIBUTORS_JSON_ADAPTER.fromJson(body.source());;
                }
            }
        });

        /*try{
            Response res = client.newCall(req).execute();
            return "";

        }catch (IOException e){
            return e.getMessage();
        }*/
    }
}
