package io.github.sridharbandi;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Reader {
    private static Reader instance = null;

    private String htmlcs;

    private Reader(){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream in = cl.getResourceAsStream("build/HTMLCS.js");
        try {
            if (in == null) {
                throw new IOException("InputStream failed for build/HTMLCS.js");
            }
            htmlcs = IOUtils.toString(in, "UTF-8");
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public static Reader getInstance(){
        return (instance == null)? new Reader() : instance;
    }

    public String getHTMLCS(){
        return htmlcs;
    }
}
