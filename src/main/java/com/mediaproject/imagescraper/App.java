package com.mediaproject.imagescraper;

import java.util.logging.Logger;

import com.mediaproject.imagescraper.factory.StreamingFactory;
import com.mediaproject.locationInfo.LocationMapper;
import com.mediaproject.streamingEnums.Streamer;
import com.mediaproject.twitterClient.SearchProcessor;
import com.mediaproject.twitterClient.TrendProcessor;

import twitter4j.TwitterException;

/**
 * @author Prashanth Seralathan
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class.getName());
	private static StreamingFactory streamingFactory;

	// Initialize Streaming factories
	public static void init() {
		streamingFactory = new StreamingFactory();
	}

	public static void main(String[] args) throws TwitterException {
		logger.info("Starting the Main App");
		logger.info("Main App has completed running");
		init();

		// Initialize the twitter clients
		SearchProcessor tweetStreamer = (SearchProcessor) streamingFactory.getHandler(Streamer.TwitterSearch);
		TrendProcessor trendProcessor = (TrendProcessor) streamingFactory.getHandler(Streamer.TwitterTrend);
		
		// Kick off the Search
//		tweetStreamer.TwitterConfig();
		
		//Trending Info topics
		trendProcessor.getTrends(LocationMapper.getLocationInfo());
	}
}
