package com.example.activitylifecycleq9;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"onCreate called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onCreate called");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onStart called");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(MainActivity.this,"onResume called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onResume called");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(MainActivity.this,"onPause called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onPause called");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(MainActivity.this,"onStop called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onStop called");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(MainActivity.this,"onRestart called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onRestart called");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"onDestroy called",Toast.LENGTH_SHORT).show();

        Log.d("lifecycle","onDestroy called");
    }

}