package com.konulgurbanli.Dao;

import com.konulgurbanli.Entity.Word;
import oracle.jdbc.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konul Gurbanli on 5/31/2017.
 */

@Repository
public class WordDao {
    private static Map<Integer, Word> words;

    private String queryString;
    private static Connection con;


    public ArrayList<Word> getAllWords(){
        con=ConnectionManager.getConnection();
        ArrayList<Word> words = new ArrayList<Word>();
        try {
            CallableStatement cstmt = con.prepareCall("{? = call get_all_words()}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.executeUpdate();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while(rs.next()) {
                Word w = new Word(rs.getInt(1), rs.getString(2), rs.getInt(3));
                words.add(w);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  words;
    }

    public Word getWordById(int id){
        Word w = null;
        con=ConnectionManager.getConnection();
        try {
            CallableStatement cstmt = con.prepareCall("{? = call get_word_by_id(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            if(rs.next()) {
                w = new Word(rs.getInt(1), rs.getString(2), rs.getInt(3));
                return w;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return w;

    }

    public void deleteWordById(int id) {
        con=ConnectionManager.getConnection();
        try{
            CallableStatement cstmt = con.prepareCall("{call delete_word(?)}");
            cstmt.setInt(1, id);
            cstmt.executeUpdate();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateWord(Word word){
        con=ConnectionManager.getConnection();
        try{
            CallableStatement cstmt = con.prepareCall("{call update_word(?, ?, ?)}");
            cstmt.setInt(1, word.getId());
            cstmt.setString(2, word.getContent());
            cstmt.setInt(3, word.getLength());
            cstmt.executeUpdate();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insertWord(Word word) {
        con=ConnectionManager.getConnection();
        try{
            CallableStatement cstmt = con.prepareCall("{call insert_word(?, ?)}");
            cstmt.setString(1, word.getContent());
            cstmt.setInt(2, word.getLength());
            cstmt.executeUpdate();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int countWords(){
        con=ConnectionManager.getConnection();
        int count = 0;
        try {
            CallableStatement cstmt = con.prepareCall("{? = call count_words()}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.executeUpdate();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while(rs.next()) {
                count = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<Integer> getAllWordIds(){
        con=ConnectionManager.getConnection();
        ArrayList <Integer> ids = new ArrayList<Integer>();
        try {
            CallableStatement cstmt = con.prepareCall("{? = call get_all_word_ids()}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.executeUpdate();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while(rs.next()) {
                ids.add(rs.getInt(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

}
