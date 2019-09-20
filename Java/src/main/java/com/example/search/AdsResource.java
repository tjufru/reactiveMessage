package com.example.search;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/receiver")
public class AdsResource {

   private String word = "";


   @GET
   public String getAd() {
      System.out.println("got user query: " + word);
      return word;
   }


   @Incoming("sink")
   public void consume(String message) {
      System.out.println("got user query: " + message);
      word = message;
   }


}