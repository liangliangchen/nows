package me.chen.impl;

import me.chen.filter.FilterProcess;

/**
 * Created by cll on 2018/12/4.
 */
public class WrapFilterProcess implements FilterProcess {
	@Override
	public String process(String msg) {
		msg = msg.replaceAll("\\s*", "");
		return msg ;
	}
}
