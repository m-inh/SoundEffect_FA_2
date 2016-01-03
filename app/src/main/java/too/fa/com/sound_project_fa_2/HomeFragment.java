package too.fa.com.sound_project_fa_2;

/**
 * Created by TooNies1810 on 10/24/15.
 */

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View root;
    private Button btnAdd;
    private MainActivity2 mainActivity;
//    private FloatingActionButton fabHome;

    private String listSong[];
//            = {"Numb.mp3", "In the end.mp3", "Holiday.mp3", "Say you do.mp3",
//            "What about now.mp3", "What about now.mp3", "What about now.mp3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home_fragment, null);
        mainActivity = (MainActivity2) getActivity();
        btnAdd = (Button) root.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
//                Toast.makeText(mainActivity, "add", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                builder.setTitle("Select song");
                builder.setItems(listSong, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        mainActivity.setCurrentSong(listSong[which]);
                        mainActivity.loadFromFile(which);
                        Toast.makeText(mainActivity, listSong[which], Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

    public void setListSong(String list[]){
        this.listSong = list;
    }
}
