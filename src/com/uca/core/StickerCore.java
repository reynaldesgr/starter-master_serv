package com.uca.core;

import com.uca.dao.StickerDAO;
import com.uca.entity.StickerEntity;

import java.util.ArrayList;

public class StickerCore {
    /** Getting all the stickers in the databse **/
    public static ArrayList<StickerEntity> getAllStickers() {
        return new StickerDAO().getAllStickers();
    }
    /** Getting a sticker by giving its id **/
    public static StickerEntity getStickerById(int id){
        return new StickerDAO().getById(id);
    }

    /** Create a sticker in the database **/
    public static StickerEntity createSticker(String color, String description){
        StickerEntity sticker = new StickerEntity();
        sticker.setColor(StickerEntity.COLOR.valueOf(color));
        sticker.setDescription(description);
        return new StickerDAO().create(sticker);
    }

    /** Delete a sticker in the database **/
    public static void deleteSticker(StickerEntity sticker){
        new StickerDAO().delete(sticker);
    }

    /** Update a sticker in the database **/
    public static void updateSticker(int id, StickerEntity.COLOR color, String description){
        new StickerDAO().updateSticker(id, color.toString(), description);
    }
}
