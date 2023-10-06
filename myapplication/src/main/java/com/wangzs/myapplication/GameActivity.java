package com.wangzs.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RecyclerView gameRecycle = findViewById(R.id.gameRecycle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                }
                return 1;
            }
        });
        gameRecycle.setLayoutManager(gridLayoutManager);
        List<String> data = new ArrayList();
        for (int i = 0; i < 20; i++) {
            data.add("数据" + i);
        }
        GameListAdapter gameListAdapter = new GameListAdapter(this, data);
        gameRecycle.setAdapter(gameListAdapter);

    }
}