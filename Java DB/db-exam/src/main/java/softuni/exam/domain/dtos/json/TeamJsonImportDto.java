package softuni.exam.domain.dtos.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamJsonImportDto {
    @Expose
    private String name;
    @Expose
    @SerializedName("picture")
    private PictureJsonImportDto pictureJsonImportDto;

    public TeamJsonImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureJsonImportDto getPictureJsonImportDto() {
        return pictureJsonImportDto;
    }

    public void setPictureJsonImportDto(PictureJsonImportDto pictureJsonImportDto) {
        this.pictureJsonImportDto = pictureJsonImportDto;
    }
}
