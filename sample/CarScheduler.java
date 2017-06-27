/*
	This class is to represent a small Java app to be tested with Jenkins/Docker pipelines
*/
import java.util.*;

public class CarScheduler{
	
	public static void main(String args[]){

		System.out.println("I'm a small prototype of what is going to be the future! \\n ");
		Runnable task = () -> {
			while(true){
            	System.out.println(Thread.currentThread().getName() + " is running at " + new Date());
            	try{
            		Thread.sleep(1000);
            	}catch(Exception e){

            	}
            	
            }
        };

        Runnable task2 = () -> {
			while(true){
            	System.out.println(Thread.currentThread().getName() + " is running at " + new Date());
            	try{
            		Thread.sleep(1000);
            	}catch(Exception e){
            		
            	}
            	
            }
        };

        new Thread(task).start();
        new Thread(task2).start();
		
		
	}
}