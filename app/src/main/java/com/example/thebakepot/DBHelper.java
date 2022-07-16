package com.example.thebakepot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.thebakepot.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME="mydatabase.db";
    final  static int DBVERSION=3;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE orders"+"(id Integer primary key autoincrement,name text,phone text,price Integer,quantity Integer,image Integer,description text,foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL("Drop table if exists orders");
                onCreate(sqLiteDatabase);
    }
    public  boolean insertOrder(String name,String phone,int price,int quantity,int image,String foodname,String description){
        SQLiteDatabase database=getReadableDatabase();

        ContentValues values=new ContentValues();
        System.out.println(name+phone+price+image+description+quantity+foodname);
        values.put("name",name);
        values.put("description",description);
        values.put("phone",phone);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("foodname",foodname);

        long id=database.insert("orders",null,values);
        if(id<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<OrderModel> getOrders(){
        ArrayList<OrderModel> orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                OrderModel model = new OrderModel();
                model.setOrderNumber(cursor.getInt(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) + "");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id="+id,null);
        if(cursor!=null) {
            cursor.moveToFirst();
        }

        database.close();
        return cursor;
    }
    public  boolean updateOrder(String name,String phone,int price,int quantity,int image,String foodname,String description,int id){
        SQLiteDatabase database=getReadableDatabase();

        ContentValues values=new ContentValues();
        System.out.println(name+phone+price+image+description+quantity+foodname);
        values.put("name",name);
        values.put("description",description);
        values.put("phone",phone);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("foodname",foodname);

        long row=database.update("orders",values,"id="+id,null);
        if(row<=0){
            return false;
        }
        else{
            return true;
        }
    }

    public int deleteOrder(String id) {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }

}