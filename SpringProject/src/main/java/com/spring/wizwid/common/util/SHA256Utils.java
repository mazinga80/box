package com.spring.wizwid.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Utils {
	/**
     * 암호화해시함수, 키 파일 특정경로에 넣어놨을때
     * @param string
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEnctyptHashNoSalt(String string) 
    {
    	String sCyperText = "";
    	try
    	{
	    	MessageDigest md = MessageDigest.getInstance("SHA-256"); 
	        FileInputStream fis = new FileInputStream("c:\\loging.log");
	        byte[] dataBytes = new byte[1024];
	 
	        int nread = 0; 
	        while ((nread = fis.read(dataBytes)) != -1) {
	          md.update(dataBytes, 0, nread);
	        };
	        byte[] mdbytes = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        sCyperText = sb.toString();
	        
	        System.out.println("Hex format : " + sb.toString());
		}
    	catch( NoSuchAlgorithmException e)
    	{
    		e.printStackTrace();
    		sCyperText="";
    	}
    	catch( UnsupportedEncodingException ex)
    	{
    		ex.printStackTrace();
    		sCyperText="";
    	}
    	catch( IOException exx )
    	{
    		exx.printStackTrace();
    		sCyperText="";
    	}
        
        return sCyperText;
    }
    
    /**
     * 암호화해시함수,salt
     * @param string
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEnctyptHash(String strPlainText, String strSalt) 
    {
        // digest반복횟수(1000번은 최소 권장횟수)
        final int ITERATION_NUMBER = 1000;

        String sCyperText = "";
    	try
    	{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        digest.reset();
	        digest.update(strSalt.getBytes());
	        byte[] input = digest.digest(strPlainText.getBytes("UTF-8"));
	        for (int i = 0; i < ITERATION_NUMBER; i++) {
	            digest.reset();
	            input = digest.digest(input);
	        }
	        
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < input.length; i++) {
	          sb.append(Integer.toString((input[i] & 0xff) + 0x100, 16).substring(1));
	        }
				
	        sCyperText = sb.toString();
	    }
		catch( NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			sCyperText=null;
		}
		catch( UnsupportedEncodingException ex)
		{
			ex.printStackTrace();
			sCyperText=null;
		}
	    
	    return sCyperText;
    }
    
	/**
	* 암호화해시함수,salt
	* @param string
	* @return
	* @throws NoSuchAlgorithmException
	* @throws UnsupportedEncodingException
	*/
   	public static String SHA256Encryptor(String str) 
    {
		String SHA = null;
		
		try 
		{			
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) 
			{
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
				        
			SHA = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
			SHA = "Exception : " + e.getMessage();
		}
		
		return SHA;
    }
}

