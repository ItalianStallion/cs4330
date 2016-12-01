package lsu.team4330.justask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/*
Class for adapting Questions to the Question List in the Main Activity
TODO: Replace String lists with question details
 */
public class QuestionListAdapter extends ArrayAdapter<Question>{

    private int layoutResource;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public QuestionListAdapter(Context context, int layoutResource, List<Question> questions) {
        super(context, layoutResource, questions);
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        Question question = (Question) getItem(position);

        if (question != null) {
            TextView questionTextView = (TextView) view.findViewById(R.id.question_text_view);
            TextView senderTextView = (TextView) view.findViewById(R.id.sender_text_view);
            TextView timeTextView = (TextView) view.findViewById(R.id.time_text_view);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);

            if (questionTextView != null) {
                questionTextView.setText(question.getQuestion());
            }
            if (senderTextView != null) {
                senderTextView.setText(question.getSender().getDisplayName());
            }
            if (timeTextView != null) {
                timeTextView.setText(question.getTime());
            }
            if (imageView != null) {
                // if sender == user, message is outgoing
                if(question.getSender().getDisplayName() == user.getDisplayName()) {
                    imageView.setImageResource(R.drawable.ic_arrow_outgoing_black_50dp);
                }
                else {
                    imageView.setImageResource(R.drawable.ic_arrow_incoming_black_50dp);
                }
            }
        }

        return view;
    }
}