package org.example;

import java.net.http.HttpClient;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        CoinFetcher coinFetcher = new CoinFetcher(HttpClient.newBuilder().build());
        coinFetcher.saveCoinListToFile();



    }
}