package com.example.coffeeshop;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText emailEnter;
    private EditText passwordEnter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = view.findViewById(R.id.log_in_btn);
        emailEnter = view.findViewById(R.id.enter_email);
        passwordEnter = view.findViewById(R.id.enter_password);

        loginButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.log_in_btn) {
            String email = emailEnter.getText().toString().trim();
            String password = passwordEnter.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireActivity(), "Please enter both email and password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                navigateToHome();
            }
        }
    }

    private void navigateToHome() {
        Fragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}