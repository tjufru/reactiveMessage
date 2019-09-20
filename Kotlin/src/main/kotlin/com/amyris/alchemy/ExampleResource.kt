
package com.example.search


import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.ws.rs.GET
import javax.ws.rs.Path


@Path("/receiver")
class AdsResource {


    var word : String = "nothing happened so far"

    @GET
    fun getWords(): String {
        return word
    }


    @Incoming("sink")
    fun consume(message: String) {
        println("got user query: $message")
        word = message
    }
}
