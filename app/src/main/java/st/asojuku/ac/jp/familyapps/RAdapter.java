package st.asojuku.ac.jp.familyapps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Itchy on 2016/11/02.
 */
public class RAdapter extends RecyclerView.Adapter<RViewHolder>  {
    private ArrayList<RData> rouletteDataSet;

    public RAdapter(ArrayList<RData> roulette){
        this.rouletteDataSet = roulette;
    }

    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent , int viewType){

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout,parent,false);


        return new RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RViewHolder holder,final int listPosition){

        holder.textViewNumber.setText(Integer.toString(rouletteDataSet.get(listPosition).getNumber()));
        holder.textViewContent.setText(rouletteDataSet.get(listPosition).getContent());
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickAct(rouletteDataSet.get(listPosition).getNumber()-1);

            }
        });
    }

    public void clickAct(int num){

    }

    @Override
    public int getItemCount(){
        return rouletteDataSet.size();
    }
}
