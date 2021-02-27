package com.week_6;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class LinearSearch {


    private static InputStream createInput(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File passed to createInput() was null");
        } else {
            try {
                InputStream input = new FileInputStream(file);
                return (InputStream)(file.getName().toLowerCase().endsWith(".gz") ? new GZIPInputStream(input) : input);
            } catch (IOException var2) {
                System.err.println("Could not createInput() for " + file);
                var2.printStackTrace();
                return null;
            }
        }
    }

    private String[] loadStrings(String fich) {
        File file = new File(fich);
        InputStream is = this.createInput(file);
        if (is != null) {
            return loadStrings(is);
        } else {
            System.err.println("The file \"" + file + "\" " + "is missing or inaccessible, make sure " + "the URL is valid or that the file has been " + "added to your sketch and is readable.");
            return null;
        }
    }

    private static String[] loadStrings(InputStream input) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            return loadStrings(reader);
        } catch (IOException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static String[] loadStrings(BufferedReader reader) {
        try {
            String[] lines = new String[100];
            int lineCount = 0;

            String[] output;
            for(String line = null; (line = reader.readLine()) != null; lines[lineCount++] = line) {
                if (lineCount == lines.length) {
                    output = new String[lineCount << 1];
                    System.arraycopy(lines, 0, output, 0, lineCount);
                    lines = output;
                }
            }

            reader.close();
            if (lineCount == lines.length) {
                return lines;
            } else {
                output = new String[lineCount];
                System.arraycopy(lines, 0, output, 0, lineCount);
                return output;
            }
        } catch (IOException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    private static String findAirportCode(String city, Airport[] airports) {
        String code = "";
        boolean exit = false;
        int len = airports.length;
        int idx = 0;
        while(idx < len && !exit) {
            if(airports[idx].getCity().equals(city)) {
                exit = true;
                code = airports[idx].getCode3();
            }
            idx++;
        }
        return code;
    }

    private Airport getAirport(String line) {
        String[] fields = line.split(",");
        return new Airport(fields[2], fields[3], fields[4]);
    }

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        String[] lines = ls.loadStrings("data/airports.dat");

        Object[] arrAirport = Arrays.stream(lines)
                .map(line -> ls.getAirport(line))
                .collect(Collectors.toList()).toArray();

        Airport[] airports = new Airport[arrAirport.length];
        int idx = 0;
        for(Object ar : arrAirport){
            airports[idx] = (Airport)ar;
            idx++;
        }

        System.out.println(LinearSearch.findAirportCode("Winnipeg", airports));


        List<Airport> lsSorted = Arrays.stream(lines).map(line -> ls.getAirport(line)).collect(Collectors.toList());
        Collections.sort(lsSorted);

        lsSorted.forEach(airport -> System.out.println(airport));

    }
}
