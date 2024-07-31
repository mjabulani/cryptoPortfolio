package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class CoinFileSaver {


    public void saveCoinListToFile(String coinsJson) throws FileAlreadyExistsException {

        File file = new File("src/main/resources/coinList.txt");
        if (!file.exists()) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(coinsJson);
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new FileAlreadyExistsException("File already exists!");
        }
    }


}
