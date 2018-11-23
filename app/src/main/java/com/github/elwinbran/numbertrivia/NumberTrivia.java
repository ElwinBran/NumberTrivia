package com.github.elwinbran.numbertrivia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NumberTrivia implements Serializable
{
    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("year")
    @Expose
    private Integer year;

    @SerializedName("number")
    @Expose
    private Integer number;

    @SerializedName("found")
    @Expose
    private Boolean found;

    @SerializedName("type")
    @Expose
    private String type;

    public NumberTrivia(){}

    public String triviaText()
    {
        return this.text;
    }

    public Integer triviaNumber()
    {
        return this.number;
    }
}
