package io.github.sridharbandi;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Reader {
    private static Reader instance = null;

    private String htmlcs;
    private String axe;

    private Reader(){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream inhtmlcs = cl.getResourceAsStream("build/HTMLCS.js");
        InputStream inaxe = cl.getResourceAsStream("build/AXE.js");
        try {
            if (inhtmlcs == null) {
                throw new IOException("InputStream failed for build/HTMLCS.js");
            }
            if (inaxe == null) {
                throw new IOException("InputStream failed for build/AXE.js");
            }
            htmlcs = IOUtils.toString(inhtmlcs, "UTF-8");
            axe = IOUtils.toString(inaxe, "UTF-8");
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

    public String getAXE(){
        return axe;
    }
}
