package com.foldik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws IOException {
        Color absoluteZero = new Color(Optional.of("Absolute Zero"), "#0048BA", "rgb(0, 72, 186)");
        Color alabamaCrimson = new Color(Optional.of("Alabama Crimson"), "#AF002A", "rgb(175, 0, 42)");
        Color noNameColor = new Color(Optional.empty(), "#E3A2C3", "rgb(277, 162, 195)");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module()); // Without this Jackson would have a problem with the Optional
        ObjectWriter prettyPrinter = objectMapper.writerWithDefaultPrettyPrinter();

        // Serialize object to JSON string
        String absoluteZeroInJson = objectMapper.writeValueAsString(absoluteZero);
        System.out.println("Object: " + absoluteZeroInJson);

        List<Color> colors = Arrays.asList(absoluteZero, alabamaCrimson, noNameColor);
        String colorsInJson = objectMapper.writeValueAsString(colors);
        String colorsInJsonPretty = prettyPrinter.writeValueAsString(colors);
        System.out.println("List: " + colorsInJson);
        System.out.println("Pretty: " + colorsInJsonPretty);

        // Deserialize object from JSON string
        Color color = objectMapper.readValue(absoluteZeroInJson, Color.class);
        System.out.println(color);
    }
}
