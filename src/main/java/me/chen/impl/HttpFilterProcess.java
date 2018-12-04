package me.chen.impl;

import me.chen.filter.FilterProcess;

/**
 * Created by cll on 2018/12/4.
 */
public class HttpFilterProcess implements FilterProcess {
	@Override
	public String process(String msg) {
		msg = msg.replaceAll("^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+","");
		return msg ;
	}
}
