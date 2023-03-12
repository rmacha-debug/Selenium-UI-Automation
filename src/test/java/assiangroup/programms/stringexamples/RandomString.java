package assiangroup.programms.stringexamples;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

    public static void main(String[] args){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers)+"@gmai.com";
        System.out.println(generatedString);
    }
}
