package com.company;

import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter your Plain Text: ");
        String str = Sc.nextLine();
        System.out.println("Enter the key: ");
        int key = Sc.nextInt();
        String res = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ' '){
                res =res + ' ';
            }
            if(Character.isDigit(ch)){
                int digit = ch - '0';
                digit = digit+key;
                res = res + digit;
            }else{
                if(!Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch)){
                    res = res+ch;
                    continue;
                }
                int ASCII = ch+key;
                if(!Character.isAlphabetic((char)ASCII))
                {
                    int asciiOfCh = ch;
                    if(ASCII>90 && ASCII<97){
                        int diff = 90-asciiOfCh;
                        int KEY = key - diff;
                        char newChar = (char)(65+KEY-1);
                        res = res+newChar;
                    }else if(ASCII>=122){
                        int diff = 122-asciiOfCh;
                        int KEY = key - diff;
                        char newChar = (char)(97+KEY-1);
                        res = res+newChar;
                    }
                }else{
                    int ascii = ch + key;
                    ch = (char)ascii;
                    res = res+ch;
                }
            }
        }
        System.out.println(res);
    }
}