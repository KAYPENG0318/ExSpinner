package com.wanna.exspinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] type = new String[] {"新北市", "臺北市","基隆市"};
    private String[] tea = new String[]{"萬里區","金山區","板橋區","汐止區","深坑區","石碇區","瑞芳區","平溪區","雙溪區","貢寮區","新店區","坪林區","烏來區","永和區","中和區","土城區","三峽區","樹林區","鶯歌區","三重區","新莊區","泰山區","林口區","蘆洲區","五股區","八里區","淡水區","三芝區","石門區"};
    private String[][] type2 = new String[][]{{"萬里區","金山區","板橋區","汐止區","深坑區","石碇區","瑞芳區","平溪區","雙溪區","貢寮區","新店區","坪林區","烏來區","永和區","中和區","土城區","三峽區","樹林區","鶯歌區","三重區","新莊區","泰山區","林口區","蘆洲區","五股區","八里區","淡水區","三芝區","石門區"},{"中正區","大同區","中山區","松山區","大安區","萬華區","信義區","士林區","北投區","內湖區","南港區","文山區"},{"仁愛區","信義區","中正區","中山區","安樂區","暖暖區","七堵區"}};
    private Spinner sp;//第一個下拉選單
    private Spinner sp2;//第二個下拉選單
    private Context context;

    ArrayAdapter<String> adapter ;
    ArrayAdapter<String> adapter2;

    //------------------------------------------------------------------
    ArrayList<Map<String,Object>> mylist=new ArrayList();
    Spinner spMap,spMap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //InputStreamReader inputStreamReader;



        context = this;

        //程式剛啟始時載入第一個下拉選單
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp = (Spinner) findViewById(R.id.type);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(selectListener);

        //因為下拉選單第一個為茶類，所以先載入茶類群組進第二個下拉選單
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tea);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2 = (Spinner) findViewById(R.id.type2);
        sp2.setAdapter(adapter2);


        //-----------------------------------------------------------------------------------------
        spMap=(Spinner)findViewById(R.id.spinner);
        spMap=(Spinner)findViewById(R.id.spinner2);
        HashMap<String,Object> m1 = new HashMap<>();
        m1.put("city","台北");
        m1.put("code","02");
        mylist.add(m1);


    }

    //第一個下拉類別的監看式
    private AdapterView.OnItemSelectedListener selectListener = new AdapterView.OnItemSelectedListener(){
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
            //讀取第一個下拉選單是選擇第幾個
            int pos = sp.getSelectedItemPosition();
            //重新產生新的Adapter，用的是二維陣列type2[pos]
            adapter2 = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, type2[pos]);
            //載入第二個下拉選單Spinner
            sp2.setAdapter(adapter2);
        }

        public void onNothingSelected(AdapterView<?> arg0){

        }

    };


    public void click1(View v)
    {

    }



}
