package com.cmpe239.examples;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */
    public static void main(String[] args) {
        /*if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }*/
        ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("pYQw3ru0GHIjdl7mc6g6awlVI")
    	  .setOAuthConsumerSecret("bLoDENtAOIkvS9G68wYZsyPJV6K5ZUw6pOEsHvL4OKUcSIPum5")
    	  .setOAuthAccessToken("58667876-FRhxxGTFHJjh9ekrFSLm73TIZDwS0fpu7HwJMwKvb")
    	  .setOAuthAccessTokenSecret("Ly7J1YJgrSh3nWX31qzl4QELDI2oRcouFruOcCThjtYld");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
        try {
            Query query = new Query("MakeInIndia");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
