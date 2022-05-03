package com.strawhat.shiro.tools;


import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * The type Digests util.
 * 封装加密规则
 */
public class DigestsUtil {

    public static final  String SHA256 = "SHA-256";
    public static final Integer ITERATIONS =1024;

    /**
     * Sha 3 string.
     *密码生成规则
     * @param input the input
     * @param salt  the salt
     * @return the string
     */
    public static String sha3(String input,String salt) {
        return new SimpleHash(SHA256, input, salt,ITERATIONS).toString();
    }

    /**
     * Entrypt password 1 string.
     *生成密码
     * @param passwordPlain the password plain
     * @return the string
     */
    public static String entryptPassword(String passwordPlain,String salt) {
        String password =sha3(passwordPlain,salt);
        System.out.println("salt"+"--"+password);
        return password;

    }

}
