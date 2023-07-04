//package com.example.demo;
//
//import org.bouncycastle.util.io.pem.PemObject;
//import org.bouncycastle.util.io.pem.PemWriter;
//
//import javax.crypto.Cipher;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.security.*;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//
///**
// * @author mazh
// * @date 2022/5/17 19:44
// */
//public class RSATest {
//
//    public static void main(String[] args) {
//        doIt("测试非对称加密");
//    }
//
//
//    private static void doIt(String data){
//        try {
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            keyPairGenerator.initialize(2048);
//            KeyPair keyPair = keyPairGenerator.generateKeyPair();
//            RSAPublicKey rsaPublicKey=(RSAPublicKey) keyPair.getPublic();           //公钥
//            RSAPrivateKey rsaPrivateKey=(RSAPrivateKey) keyPair.getPrivate();       //私钥
//            System.out.println("public key:"+ Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded()));
//            System.out.println("public key pem:"+ pem(rsaPublicKey));
//            System.out.println("private key:"+Base64.getEncoder().encodeToString(rsaPrivateKey.getEncoded()));
//
//            //公钥加密，私钥解密--加密
//            X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(rsaPublicKey.getEncoded());
//            KeyFactory keyFactory=KeyFactory.getInstance("RSA");
//            PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
//            Cipher cipher=Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
//            byte[]result = cipher.doFinal(data.getBytes());
//            System.out.println("RSA公钥加密，私钥解密--加密:"+Base64.getEncoder().encodeToString(result));
//
//            //公钥加密，私钥解密--解密
//            PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
//            keyFactory=KeyFactory.getInstance("RSA");
//            PrivateKey privateKey =keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//            cipher=Cipher.getInstance("RSA");
//            cipher.init(Cipher.DECRYPT_MODE,privateKey);
//            result=cipher.doFinal(result);
//            System.out.println("RSA公钥加密，私钥解密--解密:"+new String(result));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    private static String pem(  RSAPublicKey publicKey){
//        try {
//            StringWriter writer = new StringWriter();
//            PemWriter pemWriter = new PemWriter(writer);
//            pemWriter.writeObject(new PemObject("PUBLIC KEY", publicKey.getEncoded()));
//            pemWriter.flush();
//            pemWriter.close();
//            return writer.toString();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
