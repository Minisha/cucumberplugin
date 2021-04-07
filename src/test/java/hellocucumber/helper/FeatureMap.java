package hellocucumber.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FeatureMap {

    public static final Map<String, String> featureMap = new HashMap<>();

    public static void generateMap() {
        String filePath = "/Users/minisha/workspace/hellocucumber/src/test/resources/hellocucumber/test.feature";

        String[] fileNameArray = filePath.split("/");
        String fileName = fileNameArray[fileNameArray.length-1];
        StringBuilder builder = new StringBuilder();
        for (int i =0; i<fileNameArray.length-1; i++) {
            builder.append(fileNameArray[i]);
            builder.append("/");
        }
        builder.append("feature/"+fileName);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(builder.toString()));

            try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
                stream.forEach(l -> {
                    String lineToWrite = null;
                    if (l.contains("[Group")) {
                        String answer = l.substring(l.indexOf("[") + 1, l.indexOf("]"));
                        System.out.println(answer);
                        lineToWrite = l.replaceAll("\\[(.*?)\\]", "");
                        featureMap.put(lineToWrite, answer.split(":")[1]);
                    } else {
                        lineToWrite = l;
                    }
                    try {
                        writer.append(lineToWrite);
                        writer.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();

            } catch (Exception e) {
                System.out.println(e);
            }

            featureMap.forEach((k, v) -> System.out.println(k + "-" + v));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        generateMap();
    }
}
