package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingDemo {

    public static void hashText(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] input = s.getBytes();
        byte[] digest = messageDigest.digest(input);

        System.out.println("Input: " + s);
        System.out.println("Output: " + digest);
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        hashText("A quick brown fox jumped over the lazy dog");
        hashText("A quick brown fox jumped over the lazy dog");//verify - for same string
        hashText("A quick brown fox jumped over the lazy dog"); // not getting the same result
        hashText("A quick brown fox jumped oper the lazy dog"); //so how is it deterministic?

        //Ans : What you are printing is object identifier? Not sure
    }
}
