package mostwanted.domain.dtos.races;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryImportRootDto {

    @XmlElement(name = "entry")
    private List<EntryImportDto> entryImportDtoList;

    public EntryImportRootDto() {
    }

    public List<EntryImportDto> getEntryImportDtoList() {
        return entryImportDtoList;
    }

    public void setEntryImportDtoList(List<EntryImportDto> entryImportDtoList) {
        this.entryImportDtoList = entryImportDtoList;
    }
}
