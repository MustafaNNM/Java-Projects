/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;

public class Paths {
    static final String RESS_PATH = "index.txt";
    static String HOST = "http://bihap.com/img/";
    static List<String> WELLCOME_URIs;
    static HashMap<String, List<String>> CATEGORY_URIs;
    static List<String> ADVERS_URIs;
    static HashMap<String, List<String>> RECC_URIs;
    static List<String> ALL_URIs;
    static int IMAGE_COUNT_ON_EACH_PAGE;
    static int CATEGORY_COUNT;
    static int IMAGE_COUNT_IN_CATEGORY;
    static int RECOMMENDATION_COUNT;
    static int ADVERS_COUNT;

    static {
        IMAGE_COUNT_ON_EACH_PAGE = 10;
        CATEGORY_COUNT = 10;
        IMAGE_COUNT_IN_CATEGORY = 100;
        RECOMMENDATION_COUNT = 10;
        ADVERS_COUNT = 10;
    }

    public static List<String> defineAdversURIs(List<String> allUris) {
        ArrayList<String> wellcomePageURIs = new ArrayList<String>();
        int i = 0;
        while (i < ADVERS_COUNT) {
            wellcomePageURIs.add(allUris.get((int)Paths.randomWithRange(0.0, 5000.0)));
            ++i;
        }
        return wellcomePageURIs;
    }

    public static HashMap<String, List<String>> defineCategoryURIs(List<String> allUris) {
        HashMap<String, List<String>> categoryURIs = new HashMap<String, List<String>>();
        int category = 0;
        while (category < CATEGORY_COUNT) {
            ArrayList<String> uris = new ArrayList<String>();
            int i = 0;
            while (i < IMAGE_COUNT_IN_CATEGORY) {
                uris.add(allUris.get((int)Paths.randomWithRange(100.0, 5000.0)));
                ++i;
            }
            categoryURIs.put(Integer.toString(category), uris);
            ++category;
        }
        return categoryURIs;
    }

    static HashMap<String, List<String>> defineReccURIs(HashMap<String, List<String>> categoryURIs, List<String> allURIs) {
        HashMap<String, List<String>> reccURIs = new HashMap<String, List<String>>();
        Collection<List<String>> values = categoryURIs.values();
        for (List<String> list : values) {
            for (String image : list) {
                ArrayList<String> reccsPerURIs = new ArrayList<String>();
                int i = 0;
                while (i < RECOMMENDATION_COUNT) {
                    reccsPerURIs.add(allURIs.get((int)Paths.randomWithRange(100.0, 1000.0)));
                    ++i;
                }
                reccURIs.put(image, reccsPerURIs);
            }
        }
        return reccURIs;
    }

    public static List<String> defineWellcomePageURIs(List<String> allUris) {
        ArrayList<String> wellcomePageURIs = new ArrayList<String>();
        int i = 0;
        while (i < IMAGE_COUNT_ON_EACH_PAGE) {
            wellcomePageURIs.add(allUris.get((int)Paths.randomWithRange(0.0, 200.0)));
            ++i;
        }
        return wellcomePageURIs;
    }

    static List<String> getAllURIs() throws Exception {
        if (ALL_URIs == null) {
            Paths.loadURIs();
        }
        return ALL_URIs;
    }

    static List<String> loadURIs() throws Exception {
        ArrayList<String> uris = new ArrayList<String>();
        InputStream resourceStream = Paths.class.getResourceAsStream("/index.txt");
        InputStreamReader sreader = resourceStream == null ? new FileReader(new File("./files/index.txt")) : new InputStreamReader(resourceStream);
        BufferedReader reader = new BufferedReader(sreader);
        String line = null;
        int i = 0;
        while ((line = reader.readLine()) != null && i++ < 5000) {
            uris.add(String.valueOf(HOST) + line);
        }
        reader.close();
        System.out.println(String.format("%d uri loaded.", uris.size()));
        ALL_URIs = uris;
        return uris;
    }

    static List<String> loadURIsFromIndex(String uri, HttpClient httpClient) throws Exception {
        ContentResponse response = httpClient.newRequest(uri).send();
        ByteArrayInputStream is = new ByteArrayInputStream(response.getContent());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        ArrayList<String> result = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            result.add(String.valueOf(HOST) + line);
        }
        return result;
    }

    static void prepareURIs() throws Exception {
        List<String> allURIs = Paths.loadURIs();
        System.out.println("Preparing sample uris");
        WELLCOME_URIs = Paths.defineWellcomePageURIs(allURIs);
        CATEGORY_URIs = Paths.defineCategoryURIs(allURIs);
        ADVERS_URIs = Paths.defineAdversURIs(allURIs);
        RECC_URIs = Paths.defineReccURIs(CATEGORY_URIs, allURIs);
    }

    static String randomCategory() {
        return Integer.toString((int)Paths.randomWithRange(0.0, CATEGORY_COUNT));
    }

    static double randomWithRange(double min, double max) {
        double range = max - min;
        return Math.random() * range + min;
    }

    static List<String> getRandomCategory() {
        return CATEGORY_URIs.get(Integer.toString((int)Paths.randomWithRange(0.0, 10.0)));
    }
}

