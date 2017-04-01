package ecorp.stocks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aman on 12/03/17.
 */

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.myViewHolder> {

private ArrayList<StockDetails> list;

    public StockAdapter(ArrayList<StockDetails> list) {
        this.list = list;
    }


    public class myViewHolder extends RecyclerView.ViewHolder
    {

        public TextView t1,t2,t3,t4;
        public myViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.stockName);
            t2 = (TextView) itemView.findViewById(R.id.stockCurrency);
            t3 = (TextView) itemView.findViewById(R.id.stockChange);
            t4 = (TextView) itemView.findViewById(R.id.stockBid);

        }
    }


    @Override
    public StockAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);

        return new myViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(StockAdapter.myViewHolder holder, int position) {

        StockDetails s1 = list.get(position);
        holder.t1.setText(s1.getSymbol());
        holder.t2.setText(s1.getCurrency());
        holder.t3.setText(s1.getChange());
        holder.t4.setText(s1.getBid());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
