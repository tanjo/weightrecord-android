package in.tanjo.weightrecord.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeightRecordData {

  @SerializedName("data") List<WeightRecord> mData;

}
