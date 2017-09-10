package twitter;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by samar.kumar on 27/11/15.
 */
public class TwitterBot {

  public static final String mediaURL = "/Users/samar.kumar/Work/wallr/wallr.jpg";

  public static final String statusMessage = "Happy New Year,automatic wallpaper changer.\n" +
  "Limited free downloads goo.gl/3nuaIh ";

  public static void main(String args1[]) throws Exception {

    try {
      Twitter twitter = new TwitterFactory().getInstance();
      try {
        // get request token.
        // this will throw IllegalStateException if access token is already available
        //twitter.set
        RequestToken requestToken = twitter.getOAuthRequestToken();
        System.out.println("Got request token.");
        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Request token secret: " + requestToken.getTokenSecret());
        AccessToken accessToken = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
          System.out.println("Open the following URL and grant access to your account:");
          System.out.println(requestToken.getAuthorizationURL());
          System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
          String pin = br.readLine();
          try {
            if (pin.length() > 0) {
              accessToken = twitter.getOAuthAccessToken(requestToken, pin);
            } else {
              accessToken = twitter.getOAuthAccessToken(requestToken);
            }
          } catch (TwitterException te) {
            if (401 == te.getStatusCode()) {
              System.out.println("Unable to get the access token.");
            } else {
              System.out.print("Error while getting token " + te.getErrorMessage());
            }
          }
        }
        System.out.println("Got access token.");
        System.out.println("Access token: " + accessToken.getToken());
        System.out.println("Access token secret: " + accessToken.getTokenSecret());
      } catch (IllegalStateException ie) {
        // access token is already available, or consumer key/secret is not set.
        if (!twitter.getAuthorization().isEnabled()) {
          System.out.println("OAuth consumer key/secret is not set.");
          System.exit(-1);
        }
      }

      GetAvailableTrends getAvailableTrends = new GetAvailableTrends();
      getAvailableTrends.initTrends(twitter);

      while (true) {

        try {
          Status status = twitter.updateStatus(getStatusUpdate(getAvailableTrends));
          System.out.println(status.getCreatedAt() + ": Successfully updated the status"+ "to [" + status.getText() + "]." );

        } catch (Exception ex) {
          System.out.println(" Exception positing message " + ex.getLocalizedMessage());
        } finally {
          Thread.sleep(12000);
        }
      }

      //System.exit(0);

    } catch (TwitterException te) {
      te.printStackTrace();
      System.out.println("Failed to get timeline: " + te.getMessage());
      System.exit(-1);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println("Failed to read the system input.");
      System.exit(-1);
    }

  }

  static StatusUpdate getStatusUpdate(GetAvailableTrends getAvailableTrends) {
    StatusUpdate statusUpdate = new StatusUpdate(statusMessage + getAvailableTrends.getASingleTrend());
    statusUpdate.setMedia(new File(mediaURL));
    return statusUpdate;

  }
}
