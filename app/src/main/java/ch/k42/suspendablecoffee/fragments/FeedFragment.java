package ch.k42.suspendablecoffee.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.k42.suspendablecoffee.R;
import ch.k42.suspendablecoffee.minions.Emoijs;
import ch.k42.suspendablecoffee.views.TitledImageCardView;

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

        final TextView txtCard1 = (TextView) fragment.findViewById(R.id.txtCard1);
        String txt1 = Emoijs.from("Hey! Thanks a lot for the coffee, made my day! U+1F60D");
        txtCard1.setText(txt1);

        final TextView txtCard2 = (TextView) fragment.findViewById(R.id.txtCard2);
        String txt2 = Emoijs.from("Hey! Thanks a lot for the coffee, made my day! U+1F60D");
        txtCard2.setText(txt2);

        final TitledImageCardView card3 = (TitledImageCardView) fragment.findViewById(R.id.card3);
        card3.setImageResource(R.drawable.cup_girl);
        card3.setTitle("Hey! What the fuck! I burnt my f*king tongue! :(");

        return fragment;
    }

}
