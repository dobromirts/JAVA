package softuni.cardealer.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.xmlExport.CustomerExportDto;
import softuni.cardealer.domain.dtos.xmlExport.CustomerExportRootDto;
import softuni.cardealer.domain.dtos.xmlImport.CustomerDto;
import softuni.cardealer.domain.dtos.xmlImport.CustomerRootDto;
import softuni.cardealer.domain.entities.Customer;
import softuni.cardealer.repositories.CustomerRepository;
import softuni.cardealer.services.CustomerService;
import softuni.cardealer.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static String XML_CUSTOMER_FILE_PATH =
            "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\importXml\\customers.xml";
    private final static String XML_CUSTOMER_EXPORT_FILE_PATH =
            "D:\\JavaDB Advanced-Hibernate,Spring\\XmlProcessing 9\\src\\main\\resources\\exportXml\\ordered-customers.xml";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() throws JAXBException {

        CustomerRootDto list = this.xmlParser.parseXml(CustomerRootDto.class,XML_CUSTOMER_FILE_PATH);

        for (CustomerDto customerDto: list.getCustomers()) {
            Customer customer = this.modelMapper.map(customerDto, Customer.class);
            customer.setBirthDate(LocalDate.parse(customerDto.getBirthDate()));
            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public void exportCustomers() throws JAXBException {
        List<Customer> customers=this.customerRepository.findAllCustomersOrderdByBirthDate();

        List<CustomerExportDto>customerExportDtos=new ArrayList<>();

        for (Customer customer : customers) {
            CustomerExportDto customerExportDto=this.modelMapper.map(customer,CustomerExportDto.class);
            customerExportDtos.add(customerExportDto);
        }

        CustomerExportRootDto customerExportRootDto=new CustomerExportRootDto();
        customerExportRootDto.setCustomerExportDtoList(customerExportDtos);


        this.xmlParser.exportToXml(customerExportRootDto,CustomerExportRootDto.class,XML_CUSTOMER_EXPORT_FILE_PATH);

    }
}
