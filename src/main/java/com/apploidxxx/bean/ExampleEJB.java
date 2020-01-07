package com.apploidxxx.bean;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * @author Arthur Kupriyanov
 */
@Stateless
@Path("/ejb")
public class ExampleEJB implements LocalEJB{

    public String getImage(){
        return "<img src=\"https://i.imgur.com/VBCOMwl.png\" />";
    }
}
