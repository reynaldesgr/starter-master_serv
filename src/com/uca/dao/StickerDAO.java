package com.uca.dao;

import com.uca.core.StickerCore;
import com.uca.core.StudentCore;
import com.uca.core.StudentStickerCore;
import com.uca.entity.StickerEntity;
import com.uca.entity.StudentStickerEntity;

import java.sql.*;
import java.util.ArrayList;

public class StickerDAO extends _Generic<StickerEntity> {

    /** Return all Stickers present in the BDD **/
    public ArrayList<StickerEntity> getAllStickers(){
        ArrayList<StickerEntity> entities = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM stickers ORDER BY id_sticker ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                StickerEntity entity = new StickerEntity();
                entity.setId_sticker(resultSet.getInt("id_sticker"));
                entity.setColor(StickerEntity.COLOR.valueOf(resultSet.getString("color")));
                entity.setDescription(resultSet.getString("description"));
                entities.add(entity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }

    /** Insert / Create a Sticker in the BDD **/
    @Override
    public StickerEntity create(StickerEntity obj) {
        try{
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO stickers(color, description) VALUES(?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, obj.getColor().toString());
            statement.setString(2, obj.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                obj.setId_sticker(rs.getInt(1));
            }else{
                obj.setId_sticker(1);
            }
            return obj;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /** Delete a Sticker from the BDD **/
    @Override
    public void delete(StickerEntity obj) {
        try{
            /** If a sticker is assigned to a student and this sticker is about to be deleted,
               we have to delete the student too (because of foreign keys in the table
               studentsStickers) **/
            PreparedStatement statement_bis = this.connect.prepareStatement("SELECT id FROM studentsStickers WHERE sticker = ?");
            statement_bis.setInt(1,obj.getId_sticker());
            ResultSet resultSet = statement_bis.executeQuery();

            /* If there is a student who have the sticker to remove */
            while(resultSet.next()){
                PreparedStatement statement_del = this.connect.prepareStatement("DELETE FROM studentsStickers WHERE id = ?");
                statement_del.setInt(1, resultSet.getInt("id"));
                statement_del.executeUpdate();
            }
            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM stickers WHERE id_sticker = ?;");
            statement.setInt(1, obj.getId_sticker());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /** Return a Sticker object by giving its id **/
    @Override
    public StickerEntity getById(int id){
        try{
            StickerEntity s = new StickerEntity();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM stickers WHERE id_sticker = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                s.setId_sticker(resultSet.getInt("id_sticker"));
                s.setDescription(resultSet.getString("description"));
                s.setColor(StickerEntity.COLOR.valueOf(resultSet.getString("color")));
            }
            return s;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void updateSticker(int id, String color, String description){
        try{
            PreparedStatement statement = this.connect.prepareStatement("UPDATE stickers SET color = ?, description = ? WHERE id_sticker = ?");
            statement.setString(1, color);
            statement.setString(2, description);
            statement.setInt(3, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
