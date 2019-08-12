package softuni.cardealer.services;



import softuni.cardealer.domain.dtos.xmlImport.SupplierDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {
    void seedSuppliers() throws FileNotFoundException, JAXBException;
    SupplierDto getRandomSupplier();
    void exportSuppliers() throws JAXBException;
}
