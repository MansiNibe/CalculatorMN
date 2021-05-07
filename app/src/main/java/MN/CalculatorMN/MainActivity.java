package MN.CalculatorMN;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import java.lang.*;


public class MainActivity extends AppCompatActivity {
    private TextView res;
    private TextView full;
    double num;
    String operable="=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		res = (TextView)findViewById(R.id.res);
        full = (TextView)findViewById(R.id.full);


    }
    public void onClickOperator(View view) {
        Button operator=(Button)view;
        if (operator.getText().toString().equals("¢")) {
            res.setText("0");
        } else if (! operator.getText().toString().equals("=")) {
            num = Double.parseDouble(res.getText().toString());
            res.setText("");
            full.setText("0");
            res.setHint(num+""+operator.getText().toString());
            operable = operator.getText().toString();
        } else if (operator.getText().toString().equals("=")) {
            
            res.setText(res.getText().toString());
          
            switch (operable) {
                case "+" : res.setText("" + (num + Double.parseDouble(res.getText().toString()))); break;

                case "-" : res.setText("" + (num - Double.parseDouble(res.getText().toString()))); break;

                case "*" : res.setText("" + (num * Double.parseDouble(res.getText().toString()))); break;

                case "/" : res.setText("" + (num / Double.parseDouble(res.getText().toString()))); break;
            }
        }
    }
    public void onClickDigit(View view) {
        Button digit=(Button)view;
        res.setText(res.getText().toString() + digit.getText().toString());
        full.setText(full.getText().toString() + digit.getText().toString());
        try{
            res.setHint(res.getHint().toString()+digit.getText().toString());
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            
        }
        
    }
}
