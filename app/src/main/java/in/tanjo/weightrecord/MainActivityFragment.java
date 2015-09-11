package in.tanjo.weightrecord;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.tanjo.weightrecord.api.WeightRecordApi;
import in.tanjo.weightrecord.model.WeightRecordData;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

  @Bind(R.id.fragment_main_textview) TextView mTextView;

  public MainActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.bind(this, v);

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.HEROKU_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    WeightRecordApi api = retrofit.create(WeightRecordApi.class);

    Call<WeightRecordData> call = api.index();
    call.enqueue(new Callback<WeightRecordData>() {
      @Override
      public void onResponse(Response<WeightRecordData> response) {
        mTextView.setText(new Gson().toJson(response.body(), WeightRecordData.class));
      }

      @Override
      public void onFailure(Throwable t) {
        mTextView.setText(t.toString());
      }
    });

    return v;
  }
}
