package Lesson10.Task2.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SynItem{

    @SerializedName("pos")
    private String pos;

    @SerializedName("text")
    private String text;

    @SerializedName("asp")
    private String asp;
}
