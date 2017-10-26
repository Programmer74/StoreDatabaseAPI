// TODO: add later
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class PasswordConverter {
    final String key = "123";
    final Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    Cipher cipher;
    /**
     * encryptor
     */
    public String passwdToMd5(String passwd){
        try {
            cipher = Cipher.getInstance("AES");
            // encrypt
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(passwd.getBytes());
            return new String(encrypted);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * decryptor
     */
    public String md5ToPasswd(String md5){
        try {
            cipher = Cipher.getInstance("AES");

            // decrypt
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(md5.getBytes()));
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
