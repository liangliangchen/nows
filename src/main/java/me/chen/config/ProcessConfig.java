package me.chen.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import me.chen.filter.FilterProcess;
import me.chen.impl.HttpFilterProcess;
import me.chen.impl.WrapFilterProcess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * Created by cll on 2018/12/4.
 */
@Configuration
public class ProcessConfig {

	private int corePoolSize = 4;

	private int maxPoolSize = 4;

	@Bean
	public ExecutorService sendMessageExecutor() {
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
				.setNameFormat("scan-number-%d").build();

		ExecutorService executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

		return executor;
	}

	/**
	 * Set the capacity for the ThreadPoolExecutor's BlockingQueue.
	 */
	private int queueCapacity = 256;

	@Bean("httpFilterProcess")
	public FilterProcess httpFilterProcess() {
		return new HttpFilterProcess();
	}


	@Bean("numberFilterProcess")
	public FilterProcess numberFilterProcess() {
		return new WrapFilterProcess();
	}
}
