package csv;

import model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    private final String fileName;

    public CsvWriter(String... names) {
        this.fileName = String.join("_", names) + ".csv";
    }

    public boolean write(List<? extends Model> models) {
        createFile();
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            StringBuilder sb = new StringBuilder();
            models.forEach(model -> sb.append(model.toCSVString()));
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private File createFile() {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
