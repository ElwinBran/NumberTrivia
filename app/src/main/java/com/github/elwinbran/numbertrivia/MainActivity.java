package com.github.elwinbran.numbertrivia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final List<NumberTrivia> triviaList = new ArrayList<>();
        setContentView(R.layout.activity_main);
        final RecyclerView triviaView = findViewById(R.id.triviaListView);
        triviaView.setLayoutManager(new LinearLayoutManager(this));
        triviaView.setAdapter(new NumberTriviaAdapter(triviaList));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer randomNumber = new Random().nextInt();
                NumbersApiService service = NumbersApiService.retrofit.create(NumbersApiService.class);
                Call<NumberTrivia> call = service.getQuote(randomNumber);
                call.enqueue(new Callback<NumberTrivia>() {

                    @Override
                    public void onResponse(Call<NumberTrivia> call, Response<NumberTrivia> response)
                    {
                        NumberTrivia quoteItem = response.body();
                        triviaList.add(quoteItem);
                        triviaView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<NumberTrivia> call, Throwable t)
                    {
                        Log.d("error",t.toString());
                    }

                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
