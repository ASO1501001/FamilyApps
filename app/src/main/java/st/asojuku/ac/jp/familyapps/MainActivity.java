package st.asojuku.ac.jp.familyapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int ranpointer;
    private String mailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ranpointer=0;
        mailText = "";


        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定
        final RecyclerView rview = (RecyclerView)findViewById(R.id.card_list);
        rview.setLayoutManager(manager);

        final ArrayList<RData> RList = new ArrayList<RData>();
        int number=0;
        for(String content :new MyData().getContents()){

            RList.add(new RData(++number,content));
        }

        RecyclerView.Adapter adapter = new RAdapter(RList){
            @Override
            public void clickAct(int num){
                ranpointer = num;
            }
        };

        rview.setAdapter(adapter);

        Button roulette = (Button)findViewById(R.id.roulette);
        Button mail = (Button)findViewById(R.id.mail);
        ImageView image = (ImageView)findViewById(R.id.arrow);
        final TextView text = (TextView)findViewById(R.id.text);



        roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();

                ranpointer = ran.nextInt(RList.size());

                rview.smoothScrollToPosition(ranpointer);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mailText += ( RList.get(ranpointer).getContent()+ "\n" ) ;

                text.setText(mailText);
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+R.string.mailaddless);

                Intent intent =new Intent(Intent.ACTION_SENDTO,uri);

                intent.putExtra(Intent.EXTRA_SUBJECT,R.string.app_name);
                intent.putExtra(Intent.EXTRA_TEXT,mailText);

                startActivity(intent);
            }
        });

    }
}
