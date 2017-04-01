package ecorp.stocks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Aman on 12/03/17.
 */

public class StockAsync extends AsyncTask<String,Void,ArrayList<StockDetails>> {



    CourseDownloadListener listener;


    StockAsync() {

    }

    void setCourseDownloadListener(CourseDownloadListener listener) {
        this.listener = listener;
    }


    @Override
    protected ArrayList<StockDetails> doInBackground(String... params) {


        String urlString = params[0];
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return null;
            }

//            String result = "";
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
//                result = result + s.nextLine();
                stringBuffer.append(s.nextLine());
            }
            Log.i("CourseData", stringBuffer.toString());

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {

        }

        return parseCourseList(stringBuffer.toString());

    }

    private ArrayList<StockDetails> parseCourseList(String json) {

        try {
            JSONObject stockObject = new JSONObject(json);
            JSONObject query = stockObject.getJSONObject("query");
            JSONObject results = query.getJSONObject("results");
            JSONArray end = results.getJSONArray("quote");
            ArrayList<StockDetails> courseList = new ArrayList<>();

            for (int i = 0; i < end.length(); i++) {
                JSONObject courseObject = end.getJSONObject(i);
                String symbol = courseObject.getString("symbol");
                String change = courseObject.getString("Change");
                String bid=courseObject.getString("Bid");
                String currency= courseObject.getString("Currency");
                StockDetails c = new StockDetails(symbol, change, bid, currency);
                courseList.add(c);
            }
            return courseList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    protected void onPostExecute(ArrayList<StockDetails> courses) {
        super.onPostExecute(courses);
        if (listener != null)
            listener.onDownloadComplete(courses);
        // we should pass this list to CourseListActivity
    }

    public interface CourseDownloadListener {
        void onDownloadComplete(ArrayList<StockDetails> courses);
    }

}
