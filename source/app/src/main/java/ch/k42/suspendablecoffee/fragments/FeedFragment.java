package ch.k42.suspendablecoffee.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        setupTitledImageCardView(fragment, R.id.card1, R.drawable.cup_student_ben, R.drawable.six_logo, "Hey! Thanks for the coffee, really made my day U+1F60D");
        setupTitledImageCardView(fragment, R.id.card2, R.drawable.cup_thumbsup, R.drawable.aperture_logo, "Mhhhh U+2615");
        setupTitledImageCardView(fragment, R.id.card3, R.drawable.cup_o_coffee, R.drawable.black_mesa_logo, "Enjoying it, thanks.");

        return fragment;
    }

    private void setupTitledImageCardView(View view, int resId, int imgResId, int logoResId, String title) {
        final TitledImageCardView card = (TitledImageCardView) view.findViewById(resId);
        card.setImageResource(imgResId);
        card.setLogoResource(logoResId);
        card.setTitle(Emoijs.from(title));
    }

}
