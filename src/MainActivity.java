//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/*
*/
public class MainActivity extends AppCompatActivity
{
    EditText williamsInput;
    TextView williamsText;
    MyDBHandler dbHandler;
    /*
    */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        williamsInput = (EditText) findViewById(R.id.williamsInput);
        williamsText = (TextView) findViewById(R.id.williamsText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }
    /*
    */
    //Add a product to the database
    public void addButtonClicked(View view)
    {
        Products product = new Products(williamsInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }
    /*
    */
    //Delete items
    public void deleteButtonClicked(View view)
    {
        String inputText = williamsInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
    /*
    */
    //Print the database
    public void printDatabase()
    {
        String dbString = dbHandler.databaseToString();
        williamsText.setText(dbString);
        williamsInput.setText("");
    }
}