package ecorp.stocks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Stocks extends AppCompatActivity implements StockAsync.CourseDownloadListener {

    CardView cardView;
    ArrayList<StockDetails> info;
    StockAdapter stockAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

       cardView = (CardView) findViewById(R.id.cardView);
        info = new ArrayList<>();
        stockAdapter = new StockAdapter(info);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(stockAdapter);
        prepare();

    }

    private void prepare() {
        String urlString = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22YHOO%22%2C%22AAPL%22%2C%22GOOG%22%2C%22MSFT%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
        StockAsync task = new StockAsync();
        task.setCourseDownloadListener(this);
        task.execute(urlString);


    }

    public void onDownloadComplete(ArrayList<StockDetails> courseList){
        if(courseList == null){
            return;
        }
        info.clear();
        info.addAll(courseList);
        stockAdapter.notifyDataSetChanged();

    }











}