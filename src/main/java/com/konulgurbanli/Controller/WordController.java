package com.konulgurbanli.Controller;

import com.konulgurbanli.Entity.Word;
import com.konulgurbanli.Service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Konul Gurbanli on 5/31/2017.
 */
@Controller
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordService wordService;

    @RequestMapping(method= RequestMethod.GET)
//    @RequestMapping(method= RequestMethod.GET) Collection<Word>
    public String getAllWords(Map<String, Object> model){
        model.put("words", this.wordService.getAllWords());
        return "words";
    }

    @RequestMapping(value="/play", method= RequestMethod.GET)
//    @RequestMapping(method= RequestMethod.GET) Collection<Word>
    public String getRandomWord(Map<String, Object> model){
        Word w = this.wordService.getRandomWord();
        char [] letters = new char [w.getLength()];
        int n=w.getLength();
        for(int i=0; i<n; i++){
            letters[i]=w.getContent().toUpperCase().charAt(i);
        }
        for(int i=0; i<n; i++){
            int r = ThreadLocalRandom.current().nextInt(0, n);
            int r2 = ThreadLocalRandom.current().nextInt(0, n);
            char t = letters[r];
            letters[r]=letters[r2];
            letters[r2]=t;
        }
        model.put("word", letters);
        model.put("id", w.getId());
        return "game";
    }

    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String welcome(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Word getWordById(@PathVariable("id") int id){
        return wordService.getWordById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteWordById( @PathVariable("id") int id){
        wordService.deleteWordById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateWord(@RequestBody Word word){
        wordService.updateWord(word);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertWord (@RequestBody Word word){
        wordService.insertWord(word);
    }
}
