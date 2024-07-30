package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static HashMap<String, String> convertJsonToCoinList(String filePath) {

        List<Coin> coinList = new ArrayList<>();

        try {
            File file = new File(filePath);
            String jsonFileAsString;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            jsonFileAsString = bufferedReader.readLine();
            bufferedReader.close();

            JsonNode root = objectMapper.readTree(jsonFileAsString);
            HashMap<String, String> coinMap = new HashMap<>();
            for (JsonNode singleCoin : root) {
                Coin coin = new Coin();

                coin.setId(singleCoin.get("id").textValue());
                coin.setName(singleCoin.get("name").textValue());
                coin.setSymbol(singleCoin.get("symbol").textValue());

                coinMap.put(coin.getName(), coin.getId());
            }
            return coinMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
