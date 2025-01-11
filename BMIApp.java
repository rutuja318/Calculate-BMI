import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ulpatsolution.wscubetechstudy.R;

public class BMIApp extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmiapp);

        TextView txtResult;
        LinearLayout l;
        EditText edtweight,edtheightF,edtheightI;
        Button btncalculate;

        edtweight=findViewById(R.id.editweight);
        edtheightF=findViewById(R.id.editHeightft);
        edtheightI=findViewById(R.id.editHeightIn);
        txtResult=findViewById(R.id.txtResult);
        btncalculate=findViewById(R.id.calculatebmi);
        l=findViewById(R.id.linearname);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                int w=Integer.parseInt(edtweight.getText().toString());
                int ft=Integer.parseInt(edtheightF.getText().toString());
                int hI=Integer.parseInt(edtheightI.getText().toString());

                int totalIn=ft*12+hI;
               double totalCm=totalIn*2.53;
               double totalmeter=totalCm/100;

               double bmi=w/(totalmeter*totalmeter);
               if(bmi>25)
               {
                   txtResult.setText("You are Overweight!!");
                   l.setBackgroundColor(getResources().getColor(R.color.overweight));
               } else if (bmi<18) {
                   txtResult.setText("You are Underweigt!!");
                   l.setBackgroundColor(getResources().getColor(R.color.lowerweight));

               }
               else
               {
                   txtResult.setText("You are Healthy!!");
                   l.setBackgroundColor(getResources().getColor(R.color.healthy));
               }
            }
        });

    }
}
