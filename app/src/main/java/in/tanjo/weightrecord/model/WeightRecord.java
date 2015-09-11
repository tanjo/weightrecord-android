package in.tanjo.weightrecord.model;

import com.google.gson.annotations.SerializedName;

public class WeightRecord {
  @SerializedName("weight") float mWeight;
  @SerializedName("fat") float mFat;
  @SerializedName("date") String mString;
  @SerializedName("id") String mId;
}
