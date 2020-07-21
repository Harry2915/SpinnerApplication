package harish.hibare.spinnerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //declaring variables
    TextView textView;
    EditText editText;
    Spinner spinner;
    static String string,string1;
    RadioButton radioButton,radioButton1;
    RadioGroup radioGroup;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linking declared variables with id (mentioned in xml flie) to assign some task..
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        //performs task when checked field is changed(ie checkbox is ticked/not ticked)
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //method where task is assigned to checkbox event
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //checks whether checkbox is ticked,if yes this task is invoked
                if(compoundButton.isChecked())
                {
                    editText.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else  //if check box is not ticked,this task is invoked
                {
                    editText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        //method for spinner (tasks assigned on spinner)
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //adapter view is used for binding or connecting data
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= editText.getText().toString().trim();
                string= String.valueOf(adapterView.getItemAtPosition(i));//stores the value of ith position in string variable
                string=string + "\n Welcome " +s +string1;//concatenate string with welcome and string
                textView.setText(string);//displaying the string in textview
            }

            @Override
            //method of spinner if nothing is selected from options
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
//method for radio button(tasks to be performed on clicking radio button
    public void onRadioButtonClicked(View view) {
        boolean status_checked=((RadioButton)view).isChecked();//sets true is radio button is selected
        switch (view.getId())
        {
            case R.id.radioButton://is invoked if button is checked
                if(status_checked)
                {
                    string1= "\n"+"Gender "+radioButton.getText().toString().trim();
                }

                break;
            case R.id.radioButton2://is invoked if button is checked
                if(status_checked) {
                    string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
                }
                break;
        }

    }
}