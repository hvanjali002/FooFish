package com.Foofish.FoofishRest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Foofish.model.SetupDeviceConfigRequestModel;
import com.Foofish.service.GetDeviceConfigService;
import com.Foofish.service.SetDeviceConfigService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource/")
public class MyResource {
    SetDeviceConfigService setDeviceConfigService = new SetDeviceConfigService();
    GetDeviceConfigService getDeviceConfigService = new GetDeviceConfigService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
   /* @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    } */

    @POST
    @Path("setDeviceConfig")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String setDeviceConfig(SetupDeviceConfigRequestModel setupDeviceConfigRequestModel) {
        return setDeviceConfigService.setDeviceConfig(setupDeviceConfigRequestModel);
    }

    @GET
    @Path("getDeviceConfig")
    @Produces(MediaType.APPLICATION_JSON)
    public SetupDeviceConfigRequestModel getDeviceConfig() {
        return getDeviceConfigService.getDeviceConfig();
    }

    @POST
    @Path("setScreenshot")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

            String uploadedFileLocation = "./" + fileDetail.getFileName();

            // save it
            writeToFile(uploadedInputStream, uploadedFileLocation);

            String output = "File uploaded to : " + uploadedFileLocation;

            return Response.status(200).entity(output).build();

        }

        // save uploaded file to new location
        private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

            try {
                OutputStream out = new FileOutputStream(new File(
                        uploadedFileLocation));
                int read = 0;
                byte[] bytes = new byte[1024];

                out = new FileOutputStream(new File(uploadedFileLocation));
                while ((read = uploadedInputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.flush();
                out.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }



}
