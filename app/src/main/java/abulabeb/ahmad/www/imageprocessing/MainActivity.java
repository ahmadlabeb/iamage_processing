package abulabeb.ahmad.www.imageprocessing;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button aboutButton,cullUSButton,writeNotsButton,choseImage;
    private ImageView TestImage_processimageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call_AllId();
        showEventsButton();
    }

    private void showEventsButton() {
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutButton_Events(v);
            }
        });
        cullUSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cullUSButton_Event(v);
            }
        });
        writeNotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNotsButton_Event(v);
            }
        });
        choseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseImage_Event(v);
            }
        });
    }

    private void choseImage_Event(View v) {
        Toast.makeText(getBaseContext(),"choseImage_Event",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,1);
    }

    private void writeNotsButton_Event(View v) {
        Toast.makeText(getBaseContext(),"writeNotsButton_Event",Toast.LENGTH_LONG).show();

    }

    private void cullUSButton_Event(View v) {
        Toast.makeText(getBaseContext(),"cullUSButton_Event",Toast.LENGTH_LONG).show();

    }

    private void aboutButton_Events(View v) {
        Toast.makeText(getBaseContext(),"aboutButton",Toast.LENGTH_LONG).show();
    }


    private void call_AllId() {
        aboutButton= (Button) findViewById(R.id.about);
        cullUSButton= (Button) findViewById(R.id.cull_us);
        writeNotsButton= (Button) findViewById(R.id.write_notes);
        choseImage= (Button) findViewById(R.id.choseImage);
        TestImage_processimageView= (ImageView) findViewById(R.id.TestImage_process);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode== Activity.RESULT_OK){
              //  Bitmap bitmap= (Bitmap) data.getExtras().get("data");
                Uri imageselect=data.getData();
                String[] fileeColoms={MediaStore.Images.Media.DATA};
                Cursor cursorQoury=this.getContentResolver().query(imageselect,fileeColoms,null,null,null);
                cursorQoury.moveToFirst();
                int indexColom=cursorQoury.getColumnIndex(fileeColoms[0]);
                String filePath=cursorQoury.getString(indexColom);
                cursorQoury.close();
                 Bitmap isSelected= BitmapFactory.decodeFile(filePath);
                TestImage_processimageView.setImageBitmap(isSelected);

            }
        }
    }
}
