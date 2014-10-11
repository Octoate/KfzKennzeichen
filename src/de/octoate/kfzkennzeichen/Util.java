/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.octoate.kfzkennzeichen;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Octoate
 */
public final class Util {
    private static final String NOT_FOUND_ERROR = "Kennzeichen wurde nicht gefunden!";
    public final static Hashtable GetSignCityIndex()
    {
        Hashtable signCityIndex = new Hashtable();
        
        //load the signdata here
        int size = 0;
        byte[] buffer = new byte[30*1024]; //max 30kb for buffering
        try{
            InputStream is = Util.class.getClass().getResourceAsStream("/de/octoate/kfzkennzeichen/data/kfzkennzeichen-deutschland.csv");
            size = is.read(buffer);
            is.close();
            System.out.println("Data successfully loaded.");
        } catch (Exception e){
            throw new Error("Daten konnten nicht geladen werden!");
        } 
        
        //now parse the data (CSV)
        char firstLetter = 'A';
        Vector signCityList = new Vector();
        for (int i = 0; i < size; i++) 
        { 
            int j; 
            SignValues signValue = new SignValues();
            for (j = i; buffer[j] != ','; j++);
            signValue.setSign(new String(buffer, i, j-i));
            for (i = ++j; buffer[i] != '\n'; i++);
            signValue.setCity(new String(buffer, j, i-j));
            
            //check if we have to add a new letter to the hashtable
            if (signValue.getSign().length()!=0){
                char readLetter = signValue.getSign().charAt(0);
                if (readLetter == firstLetter){
                    //same letter, just add it
                    signCityList.addElement(signValue);
                }
                else
                {
                    //new letter in the hashtable
                    signCityIndex.put(new Character(firstLetter), signCityList);

                    //create new Vector, add the new object and change firstLetter
                    //to the readLetter
                    signCityList = new Vector();
                    signCityList.addElement(signValue);
                    firstLetter = readLetter;
                }  
            }
        }
        //don't forget to add the last vector to the hashtable!
        signCityIndex.put(new Character(firstLetter), signCityList);
        
        return signCityIndex;
    }     
    
    public static String searchForSign(Hashtable signCityIndex, String searchText)
    {
        searchText = searchText.trim().toUpperCase();
        if (searchText!=null && !searchText.equals("") && searchText.length()!=0){
            Character firstLetter = new Character(searchText.charAt(0));
            
            Vector signCityList = (Vector)signCityIndex.get(firstLetter);
            if (signCityList != null && signCityList.size()!=0){
                //now search within the list and find the fitting object
                int listSize = signCityList.size();
                for (int i = 0; i < listSize; i++){
                    SignValues signValue = (SignValues)signCityList.elementAt(i);
                    if (signValue.getSign().equals(searchText)){
                        return signValue.getCity();
                    }
                }
            } else {
                return NOT_FOUND_ERROR;
            }
        }
        
        return NOT_FOUND_ERROR;
    }
}
