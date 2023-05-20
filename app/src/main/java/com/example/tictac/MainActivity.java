package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tictac.R;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;

    int player=1;
    int [][]winningstate={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked=gamestate[tag];
        if(isWinner==false && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + "cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource((R.drawable.zero));
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningstate.length; i++) {
                if (gamestate[winningstate[i][0]] == gamestate[winningstate[i][1]] && gamestate[winningstate[i][1]] == gamestate[winningstate[i][2]] && gamestate[winningstate[i][0]] > -1) {
                    Toast.makeText(this, "Winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                isWinner=true;
                }
            }
        }

    }
    public void reset(View view)
    {
       androidx.gridlayout.widget.GridLayout gridLayout=findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
         for(int i=0;i<total_images;i++)
         {
        ImageView v= (ImageView) gridLayout.getChildAt(i);
        v.setImageDrawable(null);
          }
         isWinner=false;
         imageClicked=-1;
        player=1;
         for(int i=0;i<gamestate.length;i++)
           gamestate[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}