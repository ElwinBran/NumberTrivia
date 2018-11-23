package com.github.elwinbran.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class NumberTriviaAdapter extends RecyclerView.Adapter<NumberTriviaViewHolder>
{

    private final List<NumberTrivia> triviaList;

    public NumberTriviaAdapter(List<NumberTrivia> triviaList)
    {
        this.triviaList = triviaList;
    }

    @NonNull
    @Override
    public NumberTriviaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.element_trivia, viewGroup, false);
        return new NumberTriviaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberTriviaViewHolder numberTriviaViewHolder, int i)
    {
        String trivia = this.triviaList.get(i).triviaText();
        String number = this.triviaList.get(i).triviaNumber().toString();
        numberTriviaViewHolder.applyTriviaText(trivia);
        numberTriviaViewHolder.applyNumberText(number);
    }

    @Override
    public int getItemCount()
    {
        return this.triviaList.size();
    }
}
