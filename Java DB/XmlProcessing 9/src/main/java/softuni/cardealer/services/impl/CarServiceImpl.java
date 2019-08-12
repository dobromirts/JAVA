package softuni.cardealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.xmlExport.*;
import softuni.cardealer.domain.dtos.xmlImport.CarDto;
import softuni.cardealer.domain.dtos.xmlImport.CarRootDto;
import softuni.cardealer.domain.entities.Car;
import softuni.cardealer.domain.entities.Part;
import softuni.cardealer.repositories.CarRepository;
import softuni.cardealer.services.CarService;
import softuni.cardealer.services.PartService;
import softuni.cardealer.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements CarService {
    private static final String CAR_XML_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\importXml\\cars.xml";
    private static final String CAR_EXPORT_XML_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\exportXml\\toyota-cars.xml";
    private static final String CARS_AND_PART_EXPORT = "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\exportXml\\cars-and-parts.xml";

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, XmlParser xmlParser, PartService partService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.partService = partService;
    }

    @Transactional
    @Override
    public void seedCars() throws JAXBException {
        CarRootDto carRootDto = this.xmlParser.parseXml(CarRootDto.class, CAR_XML_PATH);
        for (CarDto carDto : carRootDto.getCarDtos()) {
            carDto.setPartDtos(this.partService.getRandomParts());
            Car car = this.modelMapper.map(carDto, Car.class);
            this.carRepository.saveAndFlush(car);

        }
    }

    @Override
    public void exportCars() throws JAXBException {
        List<Car> carList=this.carRepository.findAllByMakeOrderByModel("Toyota");
        List<CarExportDto>carExportDtos=new ArrayList<>();

        for (Car car : carList) {
            CarExportDto carExportDto=this.modelMapper.map(car,CarExportDto.class);
            carExportDtos.add(carExportDto);
        }

        CarExportRootDto exportRootDto=new CarExportRootDto();
        exportRootDto.setCarExportDtos(carExportDtos);

        this.xmlParser.exportToXml(exportRootDto,CarExportRootDto.class,CAR_EXPORT_XML_PATH);

    }

    @Override
    public void exportCarsWithParts() throws JAXBException {
        List<Car> cars = this.carRepository.findAll();

        List<CarExportDto2> carExportDtos = new ArrayList<>();
        for (Car car : cars) {
            CarExportDto2 carExportDto = this.modelMapper.map(car, CarExportDto2.class);
            List<PartExportDto> partExportDtos = new ArrayList<>();

            for (Part part : car.getParts() ) {
                PartExportDto partExportDto = this.modelMapper.map(part, PartExportDto.class);

                partExportDtos.add(partExportDto);
            }

            PartExportRootDto partExportRootDto = new PartExportRootDto();
            partExportRootDto.setPartExportDtos(partExportDtos);
            carExportDto.setPartExportRootDto(partExportRootDto);

            carExportDtos.add(carExportDto);
        }

        CarExportRootDto2 carExportRootDto = new CarExportRootDto2();
        carExportRootDto.setCarExportDto2s(carExportDtos);

        this.xmlParser.exportToXml(carExportRootDto, CarExportRootDto2.class,CARS_AND_PART_EXPORT );
    }
}
