package com.example.rexpet_careapp;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.rexpet_careapp.databinding.ActivityServiceProviderInformationBinding;

public class ServiceProviderInformation extends AppCompatActivity {

private ActivityServiceProviderInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view for the activity
        binding = ActivityServiceProviderInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up the ActionBar
        setSupportActionBar(binding.toolbar);

        // Set up the Navigation Component
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_service_provider_information);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }


}