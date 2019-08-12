package softuni.cardealer.services;



import softuni.cardealer.domain.dtos.xmlImport.PartDto;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface PartService {
    void seedParts() throws JAXBException;
    List<PartDto> getRandomParts();
}
