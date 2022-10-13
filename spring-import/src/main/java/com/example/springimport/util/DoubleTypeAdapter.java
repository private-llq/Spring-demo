//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springimport.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class DoubleTypeAdapter extends TypeAdapter<Double> {
    public DoubleTypeAdapter() {
    }

    public void write(JsonWriter writer, Double value) throws IOException {
        if (value == null) {
            writer.nullValue();
        } else {
            writer.value(value.toString());
        }

    }

    public Double read(JsonReader reader) throws IOException {
        if (reader.peek().equals(JsonToken.NULL)) {
            reader.nextNull();
            return null;
        } else {
            String value = reader.nextString();
            return Double.parseDouble(value);
        }
    }
}
