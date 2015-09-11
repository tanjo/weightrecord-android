package in.tanjo.weightrecord.api;

import in.tanjo.weightrecord.model.WeightRecordData;
import retrofit.Call;
import retrofit.http.GET;

public interface WeightRecordApi {
  @GET("/record/index")
  Call<WeightRecordData> index();
}
