package pt.ist.ap.labs;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.reflect.Modifier;

public class hello implements Message{

		public hello(){
				this.say();
		}

		public static void main(String[] args){
				System.out.println("RKO!RKO!RKO! Jose jose jose, jose de santarem");
				new hello();
				Scanner s = new Scanner(System.in);
				try{
					Class c=(Class.forName(s.next()));
					if(!Modifier.isAbstract(c.getModifiers())){
						Object  o = c.newInstance();
						if((Arrays.asList(c.getInterfaces())).contains(Message.class)){
							((Message)o).say();
						}
						System.out.println("SUCESS");
					}
					else{
							System.out.println("FODASSE TOURET!");
							}
				}catch(ClassNotFoundException e){
						System.out.println("HOLY FUCK!");
				}catch(Exception e){
				System.out.println("Windows 95 crashed!");
				}
		}

		public void say(){
				System.out.println("H4ll0 w04ld!");
		}
}
