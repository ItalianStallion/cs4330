/****************************************************************************************/
/*
/* FILE NAME: RecipientListAdapter.java
/*
/* DESCRIPTION: displays the list of recipients of the question and their responses
/*              including names and a check or 'x' representing 'yes' and 'no' responses
/*
/*
/* DATE       BY               DESCRIPTION
/* ========== ===============  =============
/* 11/25/2016 Ben Graham       Created the class
/* 11/26/2016 Ben Graham       added 'yes' and 'no' icons
/*
/****************************************************************************************/

package lsu.team4330.justask;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/*
Class for adapting JustAsk Users to the Recipient List
TODO: When Facebook integration is finished, a user class should be defined and this should adapt List<User>
 */
public class RecipientListAdapter extends ArrayAdapter<String>{

    private int layoutResource;
    // TODO: Replace and use database to load.

    //creates the recipient list adapter
    public RecipientListAdapter(Context context, int layoutResource, List<String> strings) {
        super(context, layoutResource, strings);
        this.layoutResource = layoutResource;
    }

    //displays the names of the recipients and their response
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        String name = (String) getItem(position);

        if (name != null) {
            TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);

            if (nameTextView != null) {
                nameTextView.setText(name);
            }
            if(layoutResource == R.layout.recipient_list_item_2) {
                ImageView imageView = (ImageView) view.findViewById(R.id.image_view);

                //TODO: use user_id to find response in question's recipient list in database
                if(imageView != null) {
                    Double rand = Math.random();
                    if (rand <=0.33) {
                        imageView.setImageResource(R.drawable.yes);
                    }
                    else if (rand <= 0.66) {
                        imageView.setImageResource(R.drawable.no);
                    }
                    else {
                        imageView.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }


        return view;
    }
}