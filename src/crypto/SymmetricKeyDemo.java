package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;

public class SymmetricKeyDemo {
    public static void symmetricEncryption(String inputStr) throws GeneralSecurityException{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(192);
        Key key = keyGenerator.generateKey();


        byte[] input = inputStr.repeat(16).getBytes();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//PKCS5Padding provides 5 padding to keep the length constant
        cipher.init(Cipher.ENCRYPT_MODE, key);
        System.out.print("input : " ); printByteArray(input);
        byte[] encryptedOutput = cipher.doFinal(input);

        System.out.print("Encrypted Output : " );
        System.out.println();
        printByteArray(encryptedOutput);

        //decrypt on the other end
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
        System.out.print("decrypted : " ); printByteArray(decryptedOutput);

    }

    public static void printByteArray(byte[] input){
        String s = new String(input, StandardCharsets.UTF_8);
        System.out.println(s);
    }

    public static void main(String args[]) throws GeneralSecurityException {
        symmetricEncryption("something ");
    }
}
