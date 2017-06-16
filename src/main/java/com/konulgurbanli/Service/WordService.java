package com.konulgurbanli.Service;

import com.konulgurbanli.Dao.WordDao;
import com.konulgurbanli.Entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Konul Gurbanli on 5/31/2017.
 */
@Service
public class WordService {
    @Autowired
    WordDao wordDao;

    public ArrayList<Word> getAllWords(){
        return this.wordDao.getAllWords();
    }

    public Word getWordById(int id){ return this.wordDao.getWordById(id); }

    public void deleteWordById(int id) {
        this.wordDao.deleteWordById(id);
    }

    public void updateWord(Word word){
        this.wordDao.updateWord(word);
    }

    public void insertWord(Word word) { this.wordDao.insertWord(word);}

    public Word getRandomWord(){
        int min=1;
        //number of words in db
        ArrayList<Integer> ids = this.wordDao.getAllWordIds();
        int randomNum = ThreadLocalRandom.current().nextInt(0, ids.size());
        Word word = this.wordDao.getWordById(ids.get(randomNum));
        //if no word found retry
//        if(word==null){
//            //CHANGE THIS HARDCODED VALUE
//            word=this.wordDao.getWordById(1);
//        }
        return word;
    }
}
