package com.restopedia_team.restopedia_app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.restopedia_team.restopedia_app.R;

/**
 * Created by VincentAndriK on 06/05/2017.
 */

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentImages.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentImages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentImages extends Fragment {

    public FragmentImages() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_images, container, false);
    }

    //upload image from gallery
}
