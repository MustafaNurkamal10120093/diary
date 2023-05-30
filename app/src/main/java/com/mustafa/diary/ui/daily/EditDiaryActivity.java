package com.mustafa.diary.ui.daily;

/*
 * NIM : 10120093
 *Nama : Mustafa Nurkamal
 *Kelas : IF3
 * */

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mustafa.diary.db.SQLite;
import com.mustafa.diary.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EditDiaryActivity extends AppCompatActivity{
    private EditText judulEditText, isiEditText;
    private Date date;
    private SimpleDateFormat dateFormat, monthFormat, yearFormat;
    private Button submitButton;
    private SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_diary); /*Memanggil tampilan form*/

        Bundle bundle = getIntent().getExtras();

        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        monthFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        submitButton = findViewById(R.id.submitButton);
        judulEditText = findViewById(R.id.judul);
        isiEditText = findViewById(R.id.isi);

        judulEditText.setText(bundle.getString("Judul"));
        isiEditText.setText(bundle.getString("Isi"));

        helper = new SQLite(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = bundle.getString("Id");
                String judul = judulEditText.getText().toString();
                String isi = isiEditText.getText().toString();
                String formattedDate = dateFormat.format(date);
                String formattedMonth = monthFormat.format(date);
                String formattedYear = yearFormat.format(date);

                if (TextUtils.isEmpty(judul)) {
                    judulEditText.setError("Data tidak boleh kosong");
                    judulEditText.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    isiEditText.setError("Data tidak boleh kosong");
                    isiEditText.requestFocus();
                } else {
                    boolean isSuccess = helper.updateData(id, judul, isi, formattedDate, formattedMonth, formattedYear);

                    if (isSuccess) {
                        Toast.makeText(EditDiaryActivity.this, "Catatan berhasil diubah", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(EditDiaryActivity.this, FragmentDaily.class));
                        finish();
                    } else {
                        Toast.makeText(EditDiaryActivity.this, "Catatan gagal diubah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}