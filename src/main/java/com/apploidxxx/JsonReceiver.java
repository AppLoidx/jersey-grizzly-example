package com.apploidxxx;

import com.apploidxxx.model.Message;
import com.apploidxxx.model.Point;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author Arthur Kupriyanov
 */
@Path("json")
public class JsonReceiver {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message post (Point point) {

        System.out.println("Received point : " + point.toString());

        return new Message("This is message from server", 200);

    }
}
