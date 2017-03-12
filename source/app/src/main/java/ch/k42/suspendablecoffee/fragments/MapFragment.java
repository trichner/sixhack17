package ch.k42.suspendablecoffee.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ch.k42.suspendablecoffee.R;

import static android.view.View.INVISIBLE;

public class MapFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragment = inflater.inflate(R.layout.fragment_map, container, false);

        final ImageView coffeeShopImg = (ImageView) fragment.findViewById(R.id.coffee_shop_img);
        coffeeShopImg.setVisibility(INVISIBLE);

        final Button button = (Button) fragment.findViewById(R.id.coffee_btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coffeeShopImg.getVisibility() == INVISIBLE) {
                    coffeeShopImg.setAlpha(0.0f);
                    coffeeShopImg.setTranslationY(coffeeShopImg.getHeight());
                    coffeeShopImg.setVisibility(View.VISIBLE);

                    coffeeShopImg.animate()
                            .translationY(0)
                            .alpha(1.0f);
                } else {

                    coffeeShopImg.animate()
                            .translationY(coffeeShopImg.getHeight())
                            .alpha(0.0f)
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    coffeeShopImg.setVisibility(INVISIBLE);
                                }
                            });
                }

            }
        });

        // Inflate the layout for this fragment
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
