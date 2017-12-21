package youtube;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.copyOfRange;

public class IOUtils {

    private static final int PARAMS_COUNT = 12;

    public static List<Object[]> readCsv(String name){
        String line;
        List<Object[]> list = new LinkedList<>();
        String[] parts;
        Object[] params;
        try(BufferedReader br = new BufferedReader(new FileReader(name))){
            while ((line = br.readLine()) != null) {
                parts = line.split(",");
                params = new Object[PARAMS_COUNT + 1];
                System.arraycopy(parts, 0, params, 0, PARAMS_COUNT);
                params[PARAMS_COUNT] = new HashSet<>(Arrays.asList(copyOfRange(parts, PARAMS_COUNT, parts.length)));
                list.add(params);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
