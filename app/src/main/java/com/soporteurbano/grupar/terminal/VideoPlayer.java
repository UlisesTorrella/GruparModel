package com.soporteurbano.grupar.terminal;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ulises.terminal.R;

/**
 * Created by Ulises on 27/08/2015.
 */
public class VideoPlayer extends Fragment {

    public VideoPlayer() {

    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.video_player, container, false);
        ImageView img = (ImageView)view.findViewById(R.id.propagandaImagen);
        img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.grupar1));

        return view;
    }
}
