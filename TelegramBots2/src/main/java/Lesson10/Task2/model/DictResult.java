package Lesson10.Task2.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictResult {

    @SerializedName("head")
    private Head head;

    @SerializedName("def")
    private List<DefItem> def;
}
