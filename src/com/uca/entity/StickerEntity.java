package com.uca.entity;

public class StickerEntity {

    private int id_sticker;
    private COLOR color;
    public static enum COLOR{
        ROUGE,
        BLEU,
        VERT
    }
    private String description;

    public StickerEntity(){
        // Ignored
    }

    public void setColor(COLOR c){
        this.color = c;
    }
    public String getColor(){
        return String.valueOf(color);
    }

    public void setId_sticker(int id_sticker){
        this.id_sticker = id_sticker;
    }
    public int getId_sticker(){
        return this.id_sticker;
    }

    public void setDescription(String d){
        this.description = d;
    }
    public String getDescription(){
        return this.description;
    }

}
