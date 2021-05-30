package Lesson10.Task2.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class TrItem{

        @SerializedName("pos")
        private String pos;

        @SerializedName("mean")
        private List<MeanItem> mean;

        @SerializedName("text")
        private String text;
    }

