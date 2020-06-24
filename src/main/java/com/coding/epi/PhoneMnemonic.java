package com.coding.epi;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonic {

    public  List<String> phoneMnemonic(String phoneNumber){

        char[] partialMnemonic = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();

        helper(phoneNumber, 0, partialMnemonic, mnemonics);

        return mnemonics;
    }


    private List<String> helper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
        if (digit == phoneNumber.length()) {
            mnemonics.add(new String(partialMnemonic));
        } else {
            for(int i = 0; i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); i++) {
                char ch = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = ch;
                helper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
            }

        }

        return mnemonics;
    }

    // The mapping from digit to corresponding characters.
     private static final String[] MAPPING = {"®", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


}
