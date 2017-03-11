package ch.k42.suspendablecoffee.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.k42.suspendablecoffee.R;
import ch.k42.suspendablecoffee.minions.Emoijs;

public class FeedFragment extends Fragment {

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragment = inflater.inflate(R.layout.fragment_feed, container, false);

        StringBuilder sb = new StringBuilder();
        sb.append("Hey! Thanks a lot for the coffee, made my day! ");
        sb.append(Character.toChars(0x1F60D));

        final TextView txtCard1 = (TextView) fragment.findViewById(R.id.txtCard1);
        CharSequence txt = Emoijs.from("Hey! Thanks a lot for the coffee, made my day! U+1F60D");
        txtCard1.setText(txt);

        return fragment;
    }

}
