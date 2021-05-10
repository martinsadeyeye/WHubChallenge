package com.wallethub.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String randomCharacter(int numberOfCharacter){
        String alphabet = "Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test";
        return RandomStringUtils.random(numberOfCharacter, alphabet);
    }


}
