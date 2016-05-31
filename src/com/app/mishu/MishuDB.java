package com.app.mishu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MishuDB extends SQLiteOpenHelper{
	
	
	public static final String CREATE_LOGIN="create table Login("
			+"id integer primary key autoincrement,"
			+"gonghao text," //����
			+"pswd text,"   //����
			+"lv text,"   //���� 
			+"zt integer," //��¼״̬
			+"myname text)";    //�ҵ�����
	public static final String CREATE_MYJILU="create table Myjilu("
			+"id integer primary key autoincrement,"
			+"mybumen text,"
			+"ydts text," //Ӧ������
			+"sdts text," //ʵ������
			+"ccts text," //��������
			+"qjts text," //�������
			+"jbts text,"//�Ӱ�����
			+"sfwsj text)"; //�Ƿ�Ϊ�¼�

public MishuDB(Context context,String name,CursorFactory factory,int version){
	super(context,name,factory,version);
}
@Override
public void onCreate(SQLiteDatabase db){
	
	db.execSQL(CREATE_LOGIN);
	db.execSQL(CREATE_MYJILU);

}
@Override
public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
{
	
}
}