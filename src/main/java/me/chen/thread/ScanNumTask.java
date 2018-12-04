package me.chen.thread;

import me.chen.filter.FilterProcessManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cll on 2018/12/4.
 */
public class ScanNumTask implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(ScanNumTask.class);

	private String path;

	private FilterProcessManager filterProcessManager;

	public ScanNumTask(String path, FilterProcessManager filterProcessManager) {
		this.path = path;
		this.filterProcessManager = filterProcessManager;
	}

	@Override
	public void run() {
		Stream<String> stringStream = null;
		try {
			stringStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
			//TimeUnit.MILLISECONDS.sleep(100);
		} catch (Exception e) {
			logger.error("IOException", e);
		}

		List<String> collect = stringStream.collect(Collectors.toList());
		for (String msg : collect) {
			filterProcessManager.process(msg);
		}
	}
}
