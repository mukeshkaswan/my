package com.example.websharan.app_zoro;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Show_PDF extends AppCompatActivity {
    TextView tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__pdf);
        // tx=(TextView)findViewById(R.id.tx);

        String data = getIntent().getExtras().getString("pdffff");
        Log.d("pdf_name",data);
        // tx.setText(data);
        File file = new File(Environment.getExternalStorageDirectory()
                + "/mypdf.pdf");
        WebView webview = (WebView) findViewById(R.id.webbbbb);
        final Uri uri = Uri.fromFile(file);
        try
        {
            Intent intentUrl = new Intent(Intent.ACTION_VIEW);
            intentUrl.setDataAndType(uri, "application/pdf");
            intentUrl.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentUrl);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(getApplicationContext(), "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
        }


     //   webview.getSettings().setJavaScriptEnabled(true);
      //  String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
       // webview.loadUrl("https://docs.google.com/gview?embedded=true&url=" + Environment.getExternalStorageDirectory()+"/mypdf.pdf");;
       // mWebView.loadUrl(""+ webUrl)
      /*  File file = new File(data);

        if (file.exists()) {
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(Show_PDF.this,
                        "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }

        }*/
    }

    @Override
    public void onBackPressed() {
        Show_PDF.super.onBackPressed();
    }
}
