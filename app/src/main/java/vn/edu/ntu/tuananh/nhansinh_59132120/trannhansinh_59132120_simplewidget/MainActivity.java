package vn.edu.ntu.tuananh.nhansinh_59132120.trannhansinh_59132120_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXacNhan;
    EditText edtName, edtNgaySinh, edtSoThichKhac;
    CheckBox ChBoxFilm, ChBoxMusic, ChBoxCafe, ChBoxHome, ChBoxCook;
    RadioGroup rdgGioiTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvents();
    }
    private void addView() {
        edtName = findViewById(R.id.edtName);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        ChBoxFilm = findViewById(R.id.ChBoxFilm);
        ChBoxMusic = findViewById(R.id.ChBoxMusic);
        ChBoxCafe = findViewById(R.id.ChBoxCafe);
        ChBoxHome = findViewById(R.id.ChBoxHome);
        ChBoxCook = findViewById(R.id.ChBoxCook);
        edtSoThichKhac = findViewById(R.id.edtSoThichKhac);
        btnXacNhan = findViewById(R.id.btnXacNhan);
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getThongTin();
            }
        });
    }
    private void getThongTin() {
        String gioitinh = "", sothich = "";

        switch (rdgGioiTinh.getCheckedRadioButtonId()) {
            case R.id.btnNam:
                gioitinh = "Nam";
                break;
            case R.id.btnNu:
                gioitinh = "Nữ";
                break;
        }

        if (ChBoxFilm.isChecked()) {
            sothich += "Xem phim; ";
        }
        if (ChBoxMusic.isChecked()) {
            sothich += "Nghe nhạc; ";
        }
        if (ChBoxCafe.isChecked()) {
            sothich += "Đi cafe với bạn bè; ";
        }
        if (ChBoxHome.isChecked()) {
            sothich += "Ở nhà một mình; ";
        }
        if (ChBoxCook.isChecked()) {
            sothich += "Vào bếp nấu ăn; ";
        }

        sothich += edtSoThichKhac.getText().toString();

        String ketqua = "";
        ketqua += edtName.getText().toString() + "\n"
                + "Ngày sinh: " + edtNgaySinh.getText().toString() + "\n"
                + "Giới tính: " + gioitinh + "\n"
                + "Sở thích: " + sothich;
        Toast.makeText(getApplicationContext(), ketqua, Toast.LENGTH_LONG).show();
    }

}
