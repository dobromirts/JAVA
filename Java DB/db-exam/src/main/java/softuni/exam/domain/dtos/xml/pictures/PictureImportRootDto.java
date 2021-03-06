package softuni.exam.domain.dtos.xml.pictures;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureImportRootDto {


    @XmlElement(name = "picture")
    private List<PictureImportDto> pictureImportDtos;

    public PictureImportRootDto() {
    }

    public List<PictureImportDto> getPictureImportDtos() {
        return pictureImportDtos;
    }

    public void setPictureImportDtos(List<PictureImportDto> pictureImportDtos) {
        this.pictureImportDtos = pictureImportDtos;
    }
}
