//Name: Ali Akcin
//Description: Chef App to demonstrate navigation in android studio includes sign in and registration buttons
package edu.umbc.thechefnav;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartHomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StartHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StartHomeFragment newInstance(String param1, String param2) {
        StartHomeFragment fragment = new StartHomeFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnSignInFragment = view.findViewById(R.id.btnSignInFragment);
        Button btnRegisterFragment = view.findViewById(R.id.btnRegisterFragment);

        btnSignInFragment.setOnClickListener(e -> {
            Navigation.findNavController(view).navigate(R.id.action_startHomeFragment_to_signInFragment);
        });

        btnRegisterFragment.setOnClickListener(e -> {
            Navigation.findNavController(view).navigate(R.id.action_startHomeFragment_to_registerFragment);
        });

    }
}