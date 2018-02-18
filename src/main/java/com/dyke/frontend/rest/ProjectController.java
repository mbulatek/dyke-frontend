package com.dyke.frontend.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ProjectController {
  
  static public void createProject(String name, String desc) {
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost("http://localhost:8081/addProject");
  
    StringEntity input = new StringEntity("{\"name\":\"" + name + "\",\"description\":\"" + desc + "\"}", "UTF-8");
    //StringEntity input = new StringEntity("{\"name\":\"dupa\",\"desc\":\"dupadupa\"}", "UTF-8");

    input.setContentType("application/json");
      
    try {
      post.setEntity(input);
      HttpResponse response = client.execute(post);
      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      String line = "";

      while ((line = rd.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException ioExcept) {
      System.out.println(ioExcept.getMessage());
    }
  }
}
