/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.ImageCollector;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.concurrent.Callable;

class ImageRetriever
implements Callable<Boolean> {
    private String uri;
    private String filename;

    public ImageRetriever(String uri) {
        this.uri = uri;
        this.filename = String.valueOf(ImageCollector.PATH) + uri.substring(uri.lastIndexOf("/") + 1);
    }

    @Override
    public Boolean call() throws Exception {
        Boolean result;
        result = Boolean.FALSE;
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        File targetFile = new File(this.filename);
        if (targetFile.exists()) {
            System.out.println(String.format("File already exists %s", this.filename));
            return Boolean.TRUE;
        }
        try {
            try {
                int count;
                in = new BufferedInputStream(new URL(this.uri).openStream());
                fout = new FileOutputStream(this.filename);
                byte[] data = new byte[1024];
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
                System.out.println(String.format("wrote to file:%s", this.filename));
                result = Boolean.TRUE;
            }
            catch (Exception e) {
                FileWriter errors = new FileWriter("e:/images/wallpaper/errors.txt", true);
                errors.write(String.valueOf(this.uri) + System.lineSeparator());
                errors.close();
                System.err.println("Cannot retireve " + this.uri);
                System.err.println(e.getMessage());
                if (in != null) {
                    in.close();
                }
                if (fout != null) {
                    fout.close();
                }
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
        return result;
    }
}

