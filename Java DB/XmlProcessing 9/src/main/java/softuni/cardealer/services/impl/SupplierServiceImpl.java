package softuni.cardealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.SupplierRootSeedDto;

import softuni.cardealer.domain.dtos.SupplierSeedDto;
import softuni.cardealer.domain.dtos.xmlExport.SupplierExportDto;
import softuni.cardealer.domain.dtos.xmlExport.SupplierExportRootDto;
import softuni.cardealer.domain.dtos.xmlImport.SupplierDto;
import softuni.cardealer.domain.entities.Supplier;
import softuni.cardealer.repositories.SupplierRepository;
import softuni.cardealer.services.SupplierService;
import softuni.cardealer.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class SupplierServiceImpl implements SupplierService {
    private static final String SUPPLIERS_XML_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\importXml\\suppliers.xml";
    private static final String SUPPLIERS_EXPORT_XML_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\exportXml\\local-suppliers.xml";

    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;

    public SupplierServiceImpl(ModelMapper modelMapper, SupplierRepository supplierRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException, JAXBException {
      SupplierRootSeedDto list=this.xmlParser.parseXml(SupplierRootSeedDto.class,SUPPLIERS_XML_PATH);

        for (SupplierSeedDto supplierSeedDto : list.getSupplierSeedDtos()) {
            this.supplierRepository.saveAndFlush(this.modelMapper.map(supplierSeedDto, Supplier.class));
        }

    }

    @Override
    public SupplierDto getRandomSupplier() {
        Random random = new Random();

        int id = random.nextInt((int) (this.supplierRepository.count()) - 1) +1 ;

        Supplier supplier = this.supplierRepository.getOne(id);
        return this.modelMapper.map(supplier,SupplierDto.class);
    }

    @Override
    public void exportSuppliers() throws JAXBException {
        List<Supplier> supplierList=this.supplierRepository.findAllByImportedFalse();
        List<SupplierExportDto> supplierExportDtos=new ArrayList<>();

        for (Supplier supplier : supplierList) {
            SupplierExportDto supplierExportDto=this.modelMapper.map(supplier,SupplierExportDto.class);
            supplierExportDto.setPartsCount(supplier.getParts().size());

            supplierExportDtos.add(supplierExportDto);
        }

        SupplierExportRootDto supplierExportRootDto=new SupplierExportRootDto();
        this.xmlParser.exportToXml(supplierExportRootDto,SupplierExportRootDto.class,SUPPLIERS_EXPORT_XML_PATH);

    }
}
