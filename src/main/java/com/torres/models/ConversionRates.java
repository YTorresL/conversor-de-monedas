package com.torres.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record ConversionRates(
        @SerializedName("conversion_rates") Map<String, Double> conversionRates
) {
}
