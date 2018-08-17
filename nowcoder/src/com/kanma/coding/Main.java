/**
*1. 如何收集用户输入,并进行有效过滤
*2. 负整数的处理
*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        //java中数组的初始化,要给定大小,用new创建并初始化,数组是在堆上创建的对象
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x=0, y=0;
            String inputStr = new String(sc.nextLine());
            //以";"为分割标志,将字符串分成字符串数组
            String[] steps = inputStr.split("\\;");
            for(String s:steps){
                if(s.length() == 3){
                    if(s.charAt(1)>='0' && s.charAt(1)<='9' && s.charAt(2)>='0' && s.charAt(2)<='9'){
                        if(s.charAt(0) == 'A'){
                            x -= Integer.parseInt(s.substring(1));   
                        }
                        if(s.charAt(0) == 'D'){
                            x += Integer.parseInt(s.substring(1));   
                        }
                        if(s.charAt(0) == 'W'){
                            y += Integer.parseInt(s.substring(1));   
                        }
                        if(s.charAt(0) == 'S'){
                            y -= Integer.parseInt(s.substring(1));   
                        }
                    }
                }
            } 
            System.out.println(x + "," + y);
        }

    }
}
/**

import java.util.*;
public class Main{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String[] A=str.split("\\;");
            int x=0,y=0;
            for(String string:A){
                if(string.charAt(0)=='D' && string.substring(1).matches("[0-9]+"))
                    x+=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='W' && string.substring(1).matches("[0-9]+"))
                    y+=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='S' && string.substring(1).matches("[0-9]+"))
                    y-=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='A' && string.substring(1).matches("[0-9]+"))
                    x-=Integer.parseInt(string.substring(1));

            }
            System.out.println(x+","+y);
        }

        sc.close();
    }
     
   
}

*/


//  Can i ask you a question about creating mockRESTServer? I notice that you last modified the page https://confluence.oraclecorp.com/confluence/display/fintech/Mock+REST+Server+TUD.
// I npm install package "hed-mockserver": "^1.4.0", at the end of the main.js file in this package, it has one row code: startServer('/test/', 3000, './');
// When i use hed-mockserver to create two mock server on port 3001 and 1991, the console show "Error: listen EADDRINUSE :::3000"
