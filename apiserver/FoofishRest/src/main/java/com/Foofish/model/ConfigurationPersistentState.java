package com.Foofish.model;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;


public class ConfigurationPersistentState {
    public static int motorInterval = 30;
    public static int cameraInterval = 30;

    public static InputStream uploadedInputStream;
    public static FormDataContentDisposition fileDetail;

}
