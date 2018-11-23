package com.github.elwinbran.numbertrivia;

public class NumberTrivia
{
    final private String triviaText;

    final private Integer triviaNumber;

    public NumberTrivia( String triviaText, Integer triviaNumber)
    {
        this.triviaText = triviaText;
        this.triviaNumber = triviaNumber;
    }

    public String triviaText()
    {
        return this.triviaText;
    }

    public Integer triviaNumber()
    {
        return this.triviaNumber;
    }
}
