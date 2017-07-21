package com.foldik;

import java.util.Optional;

public class Color {

    private Optional<String> name;
    private String hex;
    private String rgb;

    public Color() {
    }

    public Color(Optional<String> name, String hex, String rgb) {
        this.name = name;
        this.hex = hex;
        this.rgb = rgb;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name=" + name +
                ", hex='" + hex + '\'' +
                ", rgb='" + rgb + '\'' +
                '}';
    }
}
