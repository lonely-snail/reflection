package com.dianju.mytomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {

    private  String   url;
    private  String   method;

    public  MyRequest(InputStream  inputStream) throws IOException{
        String  httpRequest = "";
        byte[]  httpRequestBytes = new  byte[1024];
        int  length = 0;
        if((length = inputStream.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes,0,length);
        }
        /*解析 http 请求
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36
        Host: 39.96.80.78:8080
        Connection: keep-alive
        Accept-Encoding: gzip, deflate
        Request Method: GET*/
        String  httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
