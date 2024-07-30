package org.example;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        CoinFetcher coinFetcher = new CoinFetcher(HttpClient.newBuilder().build());
        coinFetcher.saveCoinListToFile();

        HashMap<String, String> coinList = CoinMapper.convertJsonToCoinList("src/main/resources/coinList.txt");
        System.out.println(coinList);

    }
}