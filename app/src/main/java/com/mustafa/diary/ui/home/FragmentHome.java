package com.mustafa.diary.ui.home;

/*
 * NIM : 10120093
 *Nama : Mustafa Nurkamal
 *Kelas : IF3
 * */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.mustafa.diary.R;

public class FragmentHome extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
