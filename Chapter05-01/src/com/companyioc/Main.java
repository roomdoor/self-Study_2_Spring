package com.companyioc;

public class Main {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";


        // 아무생각없이 만들면 계속 객체와 메소드 만들게됨
        //Base64 encoding
        //1//Base64Encode encode = new Base64Encode();
        //1//String result = encode.encode(url);
        //1//System.out.println(result);

        //2//IEncoder encode = new Base64Encoder();
        //2//String result = encode.encode(url);
        //2//System.out.println(result);


        //url encoding
        //1//UrlEncode urlEncode = new UrlEncode();
        //1//String urlResult = urlEncode.encode(url);
        //System.out.println(urlResult);

        //2//IEncoder urlEncode = new UrlEncoder();
        //2//String urlResult = urlEncode.encode(url);
        //System.out.println(urlResult);

        //3
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);


        Encoder encoder2 = new Encoder(new UrlEncoder());
        String urlResult = encoder2.encode(url);

        System.out.println(result);
        System.out.println(urlResult);
    }
}
