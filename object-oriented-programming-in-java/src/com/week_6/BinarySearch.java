package com.week_6;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class BinarySearch {
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

    private static String findAirportCodeBS(String city, Airport[] airports) {
        String code = "";

        int low = 0;
        int high = airports.length;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            int compare = city.compareTo(airports[mid].getCity());
            if(compare < 0) {
                high = mid - 1;
            } else if(compare > 0) {
                low = mid + 1;
            } else {
                return airports[mid].getCode3();
            }
        }

        return null;
    }

    private Airport getAirport(String line) {
        String[] fields = line.split(",");
        return new Airport(fields[2], fields[3], fields[4]);
    }

    public static void main (String[] args) {
        BinarySearch bs = new BinarySearch();

        String[] lines = bs.loadStrings("data/airports.dat");

        Object[] arrAirport = Arrays.stream(lines)
                .map(line -> bs.getAirport(line))
                .collect(Collectors.toList()).toArray();

        Airport[] airports = new Airport[arrAirport.length];
    }
}
