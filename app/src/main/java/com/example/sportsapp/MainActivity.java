package com.example.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements itemClickListner{
    RecyclerView recycler_view;
    private List<sports>sportsList;
    private myCustomAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recycler_view=findViewById(R.id.recycler_view);
        sportsList=new ArrayList<>();
        sports s1=new sports("VolleyBall",R.drawable.volley);
        sports s2=new sports("BasketBall",R.drawable.basketball);
        sports s3=new sports("FootBall",R.drawable.football);
        sports s4=new sports("PingPong",R.drawable.ping);
        sports s5=new sports("Tennis",R.drawable.tennis);

        sportsList.add(s1);
        sportsList.add(s2);
        sportsList.add(s3);
        sportsList.add(s4);
        sportsList.add(s5);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutManager);

        Adapter=new myCustomAdapter(sportsList);
        recycler_view.setAdapter(Adapter);
        Adapter.setClickListner(this);

        



    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this,
                "You are choosen"+" "+sportsList.get(pos).getSportName(),
                Toast.LENGTH_SHORT).show();
    }
}