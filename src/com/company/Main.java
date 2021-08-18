package com.company;

import java.util.*;
class Main {

    public static int modifyDigit(int digit, int key){
        int diff = 9-digit;
        int KEY = key-diff;
        int digitModified = KEY-1;
        if(digitModified>9){
            digitModified=(KEY%10)-1;
        }
        return digitModified;
    }


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
                int digitGot = digit+key;
                if(digitGot>9){
                    int digitModified = 0;
                    digitModified = modifyDigit(digit,key);
                    res = res + digitModified;
                }else{
                    res = res + digitGot;
                }
            }else{
                if(!Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch)){
                    res = res+ch;
                    continue;
                }
                int ASCII = ch+key;
                if(Character.isUpperCase(ch)){
                    int asciiOfCh = ch;
                    if(ASCII>90 && ASCII<122){
                        int diff = 90-asciiOfCh;
                        int KEY = key - diff;
                        char newChar = (char)(65+KEY-1);
                        res = res+newChar;
                    }else{
                        int ascii = ch + key;
                        ch = (char)ascii;
                        res = res+ch;
                    }
                }else{
                    int asciiOfCh = ch;
                    if(ASCII>=122){
                        int diff = 122-asciiOfCh;
                        int KEY = key - diff;
                        char newChar = (char)(97+KEY-1);
                        res = res+newChar;
                    }else{
                        int ascii = ch + key;
                        ch = (char)ascii;
                        res = res+ch;
                    }
                }
            }
        }
        System.out.println(res);
    }
}