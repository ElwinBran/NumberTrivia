package com.github.elwinbran.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NumberTriviaViewHolder extends RecyclerView.ViewHolder
{

    private final TextView triviaText;
    private final TextView triviaNumberView;

    public NumberTriviaViewHolder(@NonNull View itemView)
    {
        super(itemView);
        this.triviaText = itemView.findViewById(R.id.triviaTextView);
        this.triviaNumberView = itemView.findViewById(R.id.numberTextView);
    }

    public void applyTriviaText(String trivia)
    {
        this.triviaText.setText(trivia);
    }

    public void applyNumberText(String number)
    {
        this.triviaNumberView.setText(number);
    }

}
