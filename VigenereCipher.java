/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vignerecipher;

/**
 *
 * @author chrisjuste
 */
public class VigenereCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VigenereCipher a = new VigenereCipher();
        System.out.println(a.encrypt("IS INFORMATION SECURITY ESSENTIAL", "KEYWORD"));
        System.out.println(a.decrypt("YRJUW WWRIG JTFUW ERECE LCMKL CIWKR R", "KEYWORD"));
    }
    
    public String encrypt(String text, String key){
        String encryptedString = "";
        text = text.toUpperCase(); 
        for (int i=0, j=0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c < 'A' || c > 'Z') continue; //if not a letter 
            encryptedString += (char)((c + key.charAt(j) - 2 * 'A') %26 + 'A'); //add to string the encrypted letter 
            j = ++j % key.length(); //update j value 
        }
        return encryptedString;
    }
    public String decrypt(String text, String key){
        String decryptedString = "";
        text = text.toUpperCase();
        for (int i=0, j=0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c < 'A' || c > 'Z') continue; //if not a letter
            decryptedString += (char)((c - key.charAt(j) + 26) %26 + 'A'); //add to string the decrypted letter
            j = ++j % key.length(); //update j value 
        }
        return decryptedString;
    }
}
