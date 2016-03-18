package com.dan.myapp;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by dan_1 on 18-Mar-16.
 */
public class MyValueFormatter implements XAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,##0.0"); // use one decimal
    }


    public String getXValue(float value, XAxis yAxis) {
        // write your logic here
        return mFormat.format(value); // e.g. append a dollar-sign
    }

    @Override
    public String getXValue(String original, int index, ViewPortHandler viewPortHandler) {
        return null;
    }
}