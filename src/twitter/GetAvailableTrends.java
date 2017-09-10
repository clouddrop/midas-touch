package twitter;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samar.kumar on 27/11/15.
 */
public class GetAvailableTrends {

  public static int counterIndex = -1;

  private static final WOEEnum[] woeid = {WOEEnum.UnitedStates, WOEEnum.India, WOEEnum.Indonesia};

  private List<String> listOfTrends = new ArrayList<>();

  private Map<String, WOEEnum> mapOfTrends = new HashMap<>();

  public void initTrends(Twitter te) throws Exception {
    try {

      for (WOEEnum eachWoeenum : woeid) {
        Trends trends = te.getPlaceTrends(eachWoeenum.getValue());
        Thread.sleep(6000);
        for (Trend eachTrend : trends.getTrends()) {
          //System.out.println(eachWoeenum.getValue() + ":" + eachTrend.getName());
          listOfTrends.add(eachTrend.getName());
          mapOfTrends.put(eachTrend.getName(), eachWoeenum);
        }
      }

      System.out.println("done. trends : " + listOfTrends);
    } catch (TwitterException var5) {
      var5.printStackTrace();
      System.out.println("Failed to get trends: " + var5.getMessage());
      System.exit(-1);
    }

  }

  public String getASingleTrend() {
    counterIndex++;
    counterIndex = counterIndex % listOfTrends.size();
    System.out.println(
      "-------> Trend location : trend " + mapOfTrends.get(listOfTrends.get(counterIndex)) + ":" + listOfTrends
        .get(counterIndex));
    return listOfTrends.get(counterIndex);

  }
}
