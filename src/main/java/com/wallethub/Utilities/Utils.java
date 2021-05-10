package com.wallethub.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String randomCharacter(int numberOfCharacter){
        String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        return RandomStringUtils.random(numberOfCharacter, alphabet);
    }

}
