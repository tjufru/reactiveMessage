package com.example.search

import io.smallrye.reactive.messaging.annotations.Emitter
import io.smallrye.reactive.messaging.annotations.Stream
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam


@Path("/search")
class ExampleService {

    @Inject
    @Stream("queries")
    var queryEmitter: Emitter<String>? = null


    @GET
    @Path("/{word}")
    fun search(@PathParam("word") word: String?): String {

        println("about to send word: " + word!!)

        if (word.isNotEmpty()) {

            var qE= queryEmitter?.send(word)
            println("Emitter return : $qE")
            return qE.toString()
        }

        return "word was empty"
    }


}