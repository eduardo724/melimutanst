package com.meli.mutans;

import com.meli.mutans.business.SearchAdn;

/**
 * Created by Developer on 05-Feb-22.
 */
public class Main {
    public static void main(String[] args) {
        SearchAdn searchAdn = new SearchAdn();
        //String[] dna = {"ATGCGA", "AAGTGC", "ATATTT", "AGACGG", "GCGTCA", "TCACTG"};
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        System.out.println("el resultado fue:"+ searchAdn.isMutant(dna));
    }
}
