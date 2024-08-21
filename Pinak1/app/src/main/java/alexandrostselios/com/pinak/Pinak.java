package alexandrostselios.com.pinak;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import alexandrostselios.com.pinak.databinding.ActivityGuiBinding;
import alexandrostselios.com.pinak.databinding.LayoutPinakBinding;

public class Pinak extends Fragment {

    private LayoutPinakBinding binding;
    private TextView roundScore = null;

    private int score1;
    private int score2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = LayoutPinakBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.roundPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Pinak.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public void PlayPinak(EditText currentScore1, EditText currentScore2, CheckBox firstTeam1, CheckBox firstTeam2, Context context){
        if(!currentScore1.getText().toString().equals("") && !currentScore2.getText().toString().equals("")){
            if(!firstTeam1.isChecked() && !firstTeam2.isChecked()){
                Toast.makeText(context, "You need to select the First Team", Toast.LENGTH_SHORT).show();
            }else{
                if(firstTeam1.isChecked()){
                    setScoreTeam1(Integer.parseInt(currentScore1.getText().toString()) + 10);
                    setScoreTeam2(Integer.parseInt(currentScore2.getText().toString()));
                }else{
                    setScoreTeam1(Integer.parseInt(currentScore1.getText().toString()));
                    setScoreTeam2(Integer.parseInt(currentScore2.getText().toString()) + 10);
                }
            }
        }
    }

    public void setScoreTeam1(int scoreTeam1){
        this.score1 += scoreTeam1;
    }

    public void setScoreTeam2(int scoreTeam2){
        this.score2 += scoreTeam2;
    }

    public int getScoreTeam1(){
        return score1;
    }

    public int getScoreTeam2(){
        return score2;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}