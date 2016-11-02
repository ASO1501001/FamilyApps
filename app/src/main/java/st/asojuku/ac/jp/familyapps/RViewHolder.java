package st.asojuku.ac.jp.familyapps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Itchy on 2016/11/02.
 */
public class RViewHolder extends RecyclerView.ViewHolder{
    View base;
    TextView textViewNumber;
    TextView textViewContent;

    public RViewHolder(View itemView) {
        super(itemView);

        this.base=itemView;
        this.textViewNumber = (TextView) itemView.findViewById(R.id.number);
        this.textViewContent = (TextView) itemView.findViewById(R.id.content);
    }
}
