package vlu.android.demofragment_lab6_01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sta_Fragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sta_Fragment_2 extends Fragment {
    TextView tvKq;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sta_Fragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sta_Fragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static Sta_Fragment_2 newInstance(String param1, String param2) {
        Sta_Fragment_2 fragment = new Sta_Fragment_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //------------------------------
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.setFragmentResultListener("test", this,
                    new FragmentResultListener() {
                        @Override
                        public void onFragmentResult(@NonNull String requestKey,
                                                     @NonNull Bundle result) {
                            String name =result.getString("ten");
                            tvKq.setText(name);
                        }
                    });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sta__2, container, false);
        tvKq = (TextView) view.findViewById(R.id.tvHelloName);
        // Inflate the layout for this fragment
        //tvKq.setText("hahaha");
        return view;
    }
}