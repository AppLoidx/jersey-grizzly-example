package com.apploidxxx.bean;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author Arthur Kupriyanov
 */
@Local
public interface LocalEJB {
    @GET
    @Produces(MediaType.TEXT_HTML)
    String getImage();
}
