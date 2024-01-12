/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.remotedata.ws;

/**
 *
 * @author sb
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.bhaduri.remotedata.remotedatada.services.MasterDataServices;
 
@Path("/get")
public class WebDataGet {
 
    @GET    
    @Produces(MediaType.TEXT_PLAIN)
//    public String direBonjour() {        
//        return "Hello !";
//    }
//    query URI http://localhost:8080/RemoteServer/rest/get?id=1&instant=2015-07-16%2017:07:21
//      mysql> CREATE DATABASE surveillance;
//Query OK, 1 row affected (0.00 sec)

    public String insertDataToDb(@QueryParam("id") int counter, @QueryParam("instant") String dateGot) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateGot);
        MasterDataServices masterDataService = new MasterDataServices();
        masterDataService.insertIntoRemoteData(counter,dateGot);
        
        return "Data = " + counter + " ,"+dateGot;
    }
    
    
   
}
