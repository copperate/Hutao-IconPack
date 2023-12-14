package com.by_syk.lib.nanoiconpack.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.by_syk.lib.nanoiconpack.R;
import com.by_syk.lib.nanoiconpack.WallpaperViewActivity;

import java.time.Instant;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WallpaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WallpaperFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WallpaperFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WallpaperFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static WallpaperFragment newInstance(int id) {
        WallpaperFragment fragment = new WallpaperFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("pageId", id);
        fragment.setArguments(bundle);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallpaper, container, false);

    }
    public void WallpaperClicked1(View view)
    {
        Intent WallpaperPreview = new Intent(getActivity(),WallpaperViewActivity.class);
        WallpaperPreview.putExtra("BgCode",1);
        startActivity(WallpaperPreview);
    }
    public void WallpaperClicked2(View view)
    {
        Intent WallpaperPreview = new Intent(getActivity(),WallpaperViewActivity.class);
        WallpaperPreview.putExtra("BgCode",2);
        startActivity(WallpaperPreview);
    }
    public void WallpaperClicked3(View view)
    {
        Intent WallpaperPreview = new Intent(getActivity(),WallpaperViewActivity.class);
        WallpaperPreview.putExtra("BgCode",3);
        startActivity(WallpaperPreview);
    }
    public void WallpaperClicked4(View view)
    {
        Intent WallpaperPreview = new Intent(getActivity(),WallpaperViewActivity.class);
        WallpaperPreview.putExtra("BgCode",4);
        startActivity(WallpaperPreview);
    }
    public void WallpaperClicked5(View view)
    {
        Intent WallpaperPreview = new Intent(getActivity(),WallpaperViewActivity.class);
        WallpaperPreview.putExtra("BgCode",5);
        startActivity(WallpaperPreview);
    }
}