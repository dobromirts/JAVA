package softuni.cardealer.services;


import javax.xml.bind.JAXBException;

public interface CarService {
    void seedCars() throws JAXBException;

    void exportCars() throws JAXBException;

    void exportCarsWithParts() throws JAXBException;
}
