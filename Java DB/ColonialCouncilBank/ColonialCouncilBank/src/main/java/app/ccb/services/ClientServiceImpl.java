package app.ccb.services;

import app.ccb.domain.dtos.json.ClientImportDto;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.ClientRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private static final String JSON_CLIENTS_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\ColonialCouncilBank\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\clients.json";

    private final ClientRepository clientRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final EmployeeRepository employeeRepository;

    public ClientServiceImpl(ClientRepository clientRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Boolean clientsAreImported() {
        return this.clientRepository.count() != 0;
    }

    @Override
    public String readClientsJsonFile() throws IOException {
        return this.fileUtil.readFile(JSON_CLIENTS_PATH);
    }

    @Override
    public String importClients(String clients) {
       StringBuilder sb=new StringBuilder();
        ClientImportDto[]clientImportDtos=this.gson.fromJson(clients,ClientImportDto[].class);
        for (ClientImportDto clientImportDto : clientImportDtos) {
            Client client=this.modelMapper.map(clientImportDto,Client.class);
            client.setFullName(clientImportDto.getFirstName()+" "+clientImportDto.getLastName());

            Employee employee=
                    this.employeeRepository
                            .findByFirstNameAndLastName(
                                    clientImportDto.getAppointedEmployee().split("\\s+")[0],
                                    clientImportDto.getAppointedEmployee().split("\\s+")[1]);



            if (employee==null || !this.validationUtil.isValid(client)){
                sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            List<Employee> employeeList=new ArrayList<>();

            if (client.getEmployees()==null){
                employeeList.add(employee);
                client.setEmployees(employeeList);
            }else {
                client.getEmployees().add(employee);
            }
            this.clientRepository.saveAndFlush(client);
            sb.append(String.format("Successfully imported Client –%s.",client.getFullName())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public String exportFamilyGuy() {
        StringBuilder sb=new StringBuilder();
        List<Client>clients= this.clientRepository.familyGuy();


        System.out.println();

        return sb.toString();
    }
}
