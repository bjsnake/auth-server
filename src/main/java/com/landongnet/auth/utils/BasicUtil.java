package com.landongnet.auth.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * @author snake
 */
public class BasicUtil {

  public static String encode(String clientId,String clientSecret){
    String plainCredentials = clientId.concat(":").concat(clientSecret);
    String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
    return "Basic ".concat(base64Credentials);
  }

  public static String getClientId(String encodeStr){
    String decode = encodeStr.replace("Basic ", "");
    String clientInfo = new String(Base64.decodeBase64(decode));
    return clientInfo.split(":")[0];
  }

  public static void main(String[] args) {
    String encode = encode("rock_cloud", "rock_cloud");
    System.out.println(encode);
    String clientId = getClientId(encode);
    System.out.println(clientId);
  }
}
