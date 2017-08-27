# Retrofit2

- Gradle 추가
```java
compile 'com.squareup.retrofit2:retrofit:2.1.0' // Retrofit
compile 'com.squareup.retrofit2:converter-gson:2.0.0-beta3' // Gson 변환을 위한 converter
```

- github 정보 가져오기(test)
```java
public void loadItem() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<User> call = service.getUser("daaa08");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    user = response.body();

                    showData();
                } else if (response.isSuccessful()) {
                    Log.d("Response Body isNull", response.message());
                } else {
                    Log.d("Response Error Body", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }

    private void showData() {
        id.setText(""+user.getId());
        login.setText(user.getLogin());
        avatar.setText(user.getAvatar_url());
        url.setText(user.getUrl());
    }
```
- interface
```java
public interface GitHubService {
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
```
