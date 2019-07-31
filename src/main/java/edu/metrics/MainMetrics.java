package edu.metrics;

import com.codahale.metrics.Counter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

public class MainMetrics {
	
	final static MetricRegistry metrics = new MetricRegistry();
	private static final Counter pendingJobs = metrics.counter("edu.metrics.pendingJobs");
	

	public static void main(String[] args) throws Exception{
		final JmxReporter reporter = JmxReporter.forRegistry(metrics).build();
		reporter.start();
		while (true) {
			Thread.sleep(300);
			pendingJobs.inc();
		}

	}

}
