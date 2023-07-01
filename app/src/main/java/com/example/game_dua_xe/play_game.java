package com.example.game_dua_xe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class play_game extends AppCompatActivity {
    EditText datcoc;
    TextView txttien;
    CheckBox cbone,cbtwo,cbthree,cbfor,cbfive;
    SeekBar sbone,sbtwo,sbthree,sbfor,sbfive;
    ImageView startgame,nhanqua;
    int tien;
    int tiencoc;
    int REQUEST_CODE=123;
    SharedPreferences luuSotien;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        anhxa();

        luuSotien = getSharedPreferences("luuDiem", MODE_PRIVATE);

        Intent it=getIntent();
        Bundle bundle=it.getBundleExtra("sotien");
        if(bundle!=null){
            tien=(int)bundle.get("tien");
            luuTien();
        }else {
            tien = luuSotien.getInt("Tien", 300);
        }
        datcoc.setEnabled(true);
        sbone.setEnabled(false);
        sbtwo.setEnabled(false);
        sbthree.setEnabled(false);
        sbfor.setEnabled(false);
        sbfive.setEnabled(false);

        txttien.setText(tien+"$");


        countDownTimer=new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number=5;
                Random random=new Random();
                int one= random.nextInt(number);
                int two= random.nextInt(number);
                int thr= random.nextInt(number);
                int fov= random.nextInt(number);
                int five= random.nextInt(number);

                if(sbone.getProgress()>=sbone.getMax()){
                   this.cancel();
                   startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    Toast.makeText(play_game.this,"1 WIN",Toast.LENGTH_SHORT).show();
                    if(cbone.isChecked()){
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.win31);
                        mediaPlayer.start();
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.fail);
                        mediaPlayer.start();
                        tien-=tiencoc;
                        if(tien==0){
                            Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                            luuTien();
                        }else{
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }
                if(sbtwo.getProgress()>=sbtwo.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    Toast.makeText(play_game.this,"2 WIN",Toast.LENGTH_SHORT).show();
                    if(cbtwo.isChecked()){
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.win31);
                        mediaPlayer.start();
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.fail);
                        mediaPlayer.start();
                        tien-=tiencoc;
                        if(tien==0){
                            Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                            luuTien();
                        }else{
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }
                if(sbthree.getProgress()>=sbthree.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    Toast.makeText(play_game.this,"3 WIN",Toast.LENGTH_SHORT).show();
                    if(cbthree.isChecked()){
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.win31);
                        mediaPlayer.start();
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.fail);
                        mediaPlayer.start();
                        tien-=tiencoc;
                        if(tien==0){
                            Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                            luuTien();
                        }else{
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }
                if(sbfor.getProgress()>=sbfor.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    Toast.makeText(play_game.this,"4 WIN",Toast.LENGTH_SHORT).show();
                    if(cbfor.isChecked()){
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.win31);
                        mediaPlayer.start();
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.fail);
                        mediaPlayer.start();
                        tien-=tiencoc;
                        if(tien==0){
                            Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                            luuTien();
                        }else{
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }
                if(sbfive.getProgress()>=sbfive.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    Toast.makeText(play_game.this,"5 WIN",Toast.LENGTH_SHORT).show();
                    if(cbfive.isChecked()){
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.win31);
                        mediaPlayer.start();
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        MediaPlayer mediaPlayer=MediaPlayer.create(play_game.this,R.raw.fail);
                        mediaPlayer.start();
                        tien-=tiencoc;
                        if(tien==0){
                            Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                            luuTien();
                        }else{
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

                sbone.setProgress(sbone.getProgress()+one);
                sbtwo.setProgress(sbtwo.getProgress()+two);
                sbthree.setProgress(sbthree.getProgress()+thr);
                sbfor.setProgress(sbfor.getProgress()+fov);
                sbfive.setProgress(sbfive.getProgress()+five);
            }

            @Override
            public void onFinish() {

            }
        };

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=datcoc.getText().toString();
                try{
                    tiencoc=Integer.parseInt(a);
                }
                catch (Exception e){

                };

                if(cbone.isChecked()||cbtwo.isChecked()||cbthree.isChecked()||cbfor.isChecked()||cbfive.isChecked()){
                    if(a.equals("")){
                        Toast.makeText(play_game.this,"Vui lòng đặt cược trước khi chơi",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(tiencoc>tien||tiencoc==0){
                            Toast.makeText(play_game.this,"Tiền cược chưa hợp lệ",Toast.LENGTH_SHORT).show();
                        }else{
                            if(sbone.getProgress()>=sbone.getMax()
                            ||sbtwo.getProgress()>=sbtwo.getMax()
                            ||sbthree.getProgress()>=sbthree.getMax()
                            ||sbfor.getProgress()>=sbfor.getMax()
                            ||sbfive.getProgress()>=sbfive.getMax()) {
                                sbone.setProgress(0);
                                sbtwo.setProgress(0);
                                sbthree.setProgress(0);
                                sbfor.setProgress(0);
                                sbfive.setProgress(0);
                            }else{
                                sbone.setProgress(sbone.getProgress());
                                sbtwo.setProgress(sbtwo.getProgress());
                                sbthree.setProgress(sbthree.getProgress());
                                sbfor.setProgress(sbfor.getProgress());
                                sbfive.setProgress(sbfive.getProgress());
                            }

                        startgame.setVisibility(View.INVISIBLE);
                        countDownTimer.start();
                        DisableCheckBox();
                        datcoc.setEnabled(false);
                        }
                    }
                }
                else {
                    Toast.makeText(play_game.this,"Vui lòng chọn xe trước khi chơi",Toast.LENGTH_SHORT).show();
                }
            }
        });

        nhanqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tien!=0){
                    Toast.makeText(play_game.this,"Bạn vẫn còn tiền",Toast.LENGTH_SHORT).show();
                }else{
                Intent it=new Intent(play_game.this,open_box_gif.class);
                startActivityForResult(it, REQUEST_CODE);}
            }
        });
        cbone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbone.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbone.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbfor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbone.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbfive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbone.setChecked(false);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK&&data!=null){
            tien=data.getIntExtra("tienthuong",0);
            txttien.setText(tien+"$");
            luuTien();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void EnableCheckBox(){
        cbone.setEnabled(true);
        cbtwo.setEnabled(true);
        cbthree.setEnabled(true);
        cbfor.setEnabled(true);
        cbfive.setEnabled(true);
    }

    private void DisableCheckBox(){
        cbone.setEnabled(false);
        cbtwo.setEnabled(false);
        cbthree.setEnabled(false);
        cbfor.setEnabled(false);
        cbfive.setEnabled(false);
    }

    private void luuTien(){
        SharedPreferences.Editor editor=luuSotien.edit();
        editor.putInt("Tien",tien);
        editor.commit();
    }

    private void anhxa(){
        nhanqua=(ImageView)findViewById(R.id.gifbox);
        txttien=(TextView)findViewById(R.id.diem) ;
        datcoc=(EditText)findViewById(R.id.datcoc) ;
        startgame =(ImageView)findViewById(R.id.startgame);;
        cbone=(CheckBox) findViewById(R.id.checkBoxone);
        cbtwo=(CheckBox) findViewById(R.id.checkBoxtwo);
        cbthree=(CheckBox) findViewById(R.id.checkBoxthree);
        cbfor=(CheckBox) findViewById(R.id.checkBoxfor);
        cbfive=(CheckBox) findViewById(R.id.checkBoxfive);
        sbone=(SeekBar) findViewById(R.id.seekBarone);
        sbtwo=(SeekBar) findViewById(R.id.seekBartwo);
        sbthree=(SeekBar) findViewById(R.id.seekBarthree);
        sbfor=(SeekBar) findViewById(R.id.seekBarfor);
        sbfive=(SeekBar) findViewById(R.id.seekBarfive);
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        sbone.setProgress(sbone.getProgress());
        sbtwo.setProgress(sbtwo.getProgress());
        sbthree.setProgress(sbthree.getProgress());
        sbfor.setProgress(sbfor.getProgress());
        sbfive.setProgress(sbfive.getProgress());
        startgame.setVisibility(View.VISIBLE);

        AlertDialog.Builder builder=
                new AlertDialog.Builder(play_game.this);
        builder.setMessage("Bạn chắc chắn muốn thoát")
                .setCancelable(false)
                .setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                })
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        countDownTimer.cancel();
                        play_game.super.onBackPressed();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}