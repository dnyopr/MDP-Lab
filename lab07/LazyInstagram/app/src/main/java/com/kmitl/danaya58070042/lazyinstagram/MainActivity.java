package com.kmitl.danaya58070042.lazyinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kmitl.danaya58070042.lazyinstagram.adapter.PostAdapter;
import com.kmitl.danaya58070042.lazyinstagram.api.LazyInstagramAPI;
import com.kmitl.danaya58070042.lazyinstagram.api.UserProfile;
import com.kmitl.danaya58070042.lazyinstagram.fragment.MainFragment;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInterfaceListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fragment

//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
//        MainFragment mainFragment = (MainFragment) fragment;

        String username="android";
        getUserProfile(username);

        PostAdapter postAdapter = new PostAdapter(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

//        Button switchUserBtn = (Button) findViewById(R.id.switch_user_btn);
//
//        switchUserBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager
//                        .beginTransaction()
//                        .add(R.id.fragmentContainer, new MainFragment().newInstance("Activity From Access"))
//                        .commit();
//            }
//        });

    }

    private void getUserProfile(final String userName) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LazyInstagramAPI.BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LazyInstagramAPI lazyInstagramAPI = retrofit.create(LazyInstagramAPI.class);

//        Call<String> call = lazyInstagramAPI.getProfile(userName);
//        call.enqueue(new Callback<String>() { /*พิมถึงเน้*/
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String result = response.body();
//                TextView textName = (TextView) findViewById(R.id.textname);
//                textName.setText(result);
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });

        Call<UserProfile> call = lazyInstagramAPI.getProfile(userName);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()) {
                    UserProfile userProfile = response.body();
                    TextView textName = (TextView) findViewById(R.id.textName);
                    textName.setText("@" + userProfile.getUser());

                    ImageView imageUser = (ImageView) findViewById(R.id.imageUser);
                    Glide.with(MainActivity.this).load(userProfile.getUrlProfile()).into(imageUser);
                    ;
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }
}
