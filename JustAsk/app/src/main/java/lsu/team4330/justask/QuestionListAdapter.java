package lsu.team4330.justask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/*
Class for adapting Questions to the Question List in the Main Activity
TODO: Replace String lists with question details
 */
public class QuestionListAdapter extends ArrayAdapter<String>{

    private int layoutResource;

    public QuestionListAdapter(Context context, int layoutResource, List<String> strings) {
        super(context, layoutResource, strings);
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        String str = (String) getItem(position);

        if (str != null) {
            TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);

            if (nameTextView != null) {
                nameTextView.setText(str);
            }
        }

        return view;
    }
}