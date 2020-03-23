package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {

    private Set<String> parole;

    public Dictionary() {
        this.parole = new HashSet<String>();
    }

    public void loadDictionary(String language) {
        language = "src/main/resources/" + language + ".txt";
        try {
            FileReader fr = new FileReader(language);
            BufferedReader br = new BufferedReader(fr);
            String word;
            while ((word = br.readLine()) != null) {
                parole.add(word);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
    }

    public List<RichWord> splellCheckText(List<String> inputTextList) {

        List<RichWord> controllato = new ArrayList<>();
        for (String s : inputTextList) {
            controllato.add(new RichWord(s, parole.contains(s)));
        }
        return controllato;
    }

}
