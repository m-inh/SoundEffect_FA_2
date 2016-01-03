package too.fa.com.sound_project_fa_2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by TooNies1810 on 10/24/15.
 */
public class CutFragment extends Fragment implements View.OnClickListener{
    private View root;
    private MainActivity2 mainActivity;

    private Button btnSubmit;
    private TextView edtStart, edtEnd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.cut_fragment, null);
        mainActivity = (MainActivity2) getActivity();

        initViews();
        return root;
    }

    private void initViews() {
        btnSubmit = (Button) root.findViewById(R.id.btn_submitcut);


        edtStart = (TextView) root.findViewById(R.id.edt_start);
        edtEnd = (TextView) root.findViewById(R.id.edt_end);
        mainActivity.setmStartText(edtStart);
        mainActivity.setmEndText(edtEnd);
        btnSubmit.setOnClickListener(this);
        allowSubmitCut(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submitcut:
                Toast.makeText(mainActivity, "Submit", Toast.LENGTH_SHORT).show();
                mainActivity.onSave();
                break;
        }
    }

    public void allowSubmitCut(boolean allow){
        btnSubmit.setEnabled(allow);
    }
}
