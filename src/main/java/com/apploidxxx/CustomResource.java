package com.apploidxxx;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Arthur Kupriyanov
 */
@Path("custom")
public class CustomResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(){
        return "<img src=\"https://i.imgur.com/VBCOMwl.png\" />";
    }
}
