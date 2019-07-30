package com.dianju.mytomcat;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTomcat {

    private   int  port = 8080;

    private Map<String,String>   urlServletMap = new HashMap<>();

    public  MyTomcat(int port){
        this.port = port;
    }

    public  void  start(){
        initServletMapping();
        ServerSocket   serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat   is  start  ....");
            while(true){
                Socket   socket = serverSocket.accept();
                InputStream  inputStream = socket.getInputStream();
                OutputStream  outputStream = socket.getOutputStream();
                MyRequest   myRequest = new MyRequest(inputStream);
                MyResponse  myResponse = new MyResponse(outputStream);
                //请求分发
                dispatch(myRequest,myResponse);
                socket.close();
            }
        }catch (Exception  e){
            e.printStackTrace();
        }
    }
      public   void   initServletMapping(){
          for (ServletMapping  servletMapping:ServletMappingConfig.servletMappingList) {
              urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
          }
      }
      public   void    dispatch(MyRequest   myRequest,MyResponse  myResponse ){
              //去请求对应的servlet
          String   clazz  = urlServletMap.get(myRequest.getUrl());
          //反射
          try{
              Class<MyServlet>  myServletClass = (Class<MyServlet>)Class.forName(clazz);
              MyServlet  myServlet = myServletClass.newInstance();
              myServlet.service(myRequest,myResponse);
          }catch (Exception e){e.printStackTrace();}
      }

    public static void main(String[] args) {
        new  MyTomcat(8080).start();
    }
}
