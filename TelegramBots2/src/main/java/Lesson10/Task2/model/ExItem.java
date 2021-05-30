package Lesson10.Task2.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExItem{

    @SerializedName("text")
    private String text;

    @SerializedName("tr")
    private List<TrItem> tr;
}
