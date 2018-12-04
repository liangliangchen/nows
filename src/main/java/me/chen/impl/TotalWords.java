package me.chen.impl;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cll on 2018/12/4.
 */
@Component
public class TotalWords {
	private AtomicLong sum = new AtomicLong() ;

	//private long sum = 0 ;

	public void sum(int count){
		sum.addAndGet(count) ;
	}

	public  long total(){
		return sum.get() ;
	}
}
