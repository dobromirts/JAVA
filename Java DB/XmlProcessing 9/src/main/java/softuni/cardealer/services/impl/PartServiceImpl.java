package softuni.cardealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.xmlImport.PartDto;
import softuni.cardealer.domain.dtos.xmlImport.PartRootDto;
import softuni.cardealer.domain.entities.Part;
import softuni.cardealer.repositories.PartRepository;
import softuni.cardealer.services.PartService;
import softuni.cardealer.services.SupplierService;
import softuni.cardealer.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@Transactional
public class PartServiceImpl implements PartService {

    private final static String XML_PART_FILE_PATH =
            "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\importXml\\parts.xml";

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, SupplierService supplierService, XmlParser xmlParser) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws JAXBException {
        PartRootDto list = this.xmlParser.parseXml(PartRootDto.class, XML_PART_FILE_PATH);

        for (PartDto partDto: list.getPartDtos()) {
            partDto.setSupplierSeedDto(this.supplierService.getRandomSupplier());

            this.partRepository.saveAndFlush(this.modelMapper.map(partDto,Part.class));
        }
    }

    @Override
    public List<PartDto> getRandomParts() {
        List<PartDto> partDtos = new ArrayList<>();

        Random random = new Random();

        int size = random.nextInt(10) + 10;

        for (int i = 0; i < size ; i++) {
            int id = random.nextInt((int) (this.partRepository.count()) - 1) + 1;
            PartDto part = this.modelMapper.map(this.partRepository.getOne(id),PartDto.class);
            part.setSupplierSeedDto(this.supplierService.getRandomSupplier());

            partDtos.add(part);
        }

        return partDtos;
    }
}
