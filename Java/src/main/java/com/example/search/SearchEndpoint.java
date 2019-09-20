package com.example.search;


import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("/search")
public class SearchEndpoint {

    @Stream("queries")
    Emitter<String> queryEmitter;


    @GET
    @Path("/{word}")
    public String search(@PathParam("word") String word) {

        System.out.println("about to send word: " + word);

        if (!word.isEmpty()) {

            Emitter<String> qE = queryEmitter.send(word);
            System.out.println("Emitter return: " + qE);
            return word;
        }

        return "word was empty" ;
    }

}
