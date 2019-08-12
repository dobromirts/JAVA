package softuni.cardealer.services;


import softuni.cardealer.domain.dtos.xmlExport.CustomerExportRootDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CustomerService {
    void seedCustomers() throws JAXBException, FileNotFoundException;
     void exportCustomers() throws JAXBException;

}
