package app.ccb.services;

import app.ccb.domain.dtos.json.EmployeeImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BranchRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String JSON_CLIENTS_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\ColonialCouncilBank\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final BranchRepository branchRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(JSON_CLIENTS_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder sb=new StringBuilder();
        EmployeeImportDto[]employeeImportDtos=this.gson.fromJson(employees,EmployeeImportDto[].class);
        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {
            Employee employee=this.modelMapper.map(employeeImportDto,Employee.class);
            employee.setFirstName(employeeImportDto.getFullName().split("\\s+")[0]);
            employee.setLastName(employeeImportDto.getFullName().split("\\s+")[1]);

            Branch branch=this.branchRepository.findByName(employeeImportDto.getBranchName());
            if (branch==null || !this.validationUtil.isValid(employee)){
                sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            employee.setBranch(branch);
            this.employeeRepository.saveAndFlush(employee);
            sb.append(String.format("Successfully imported Employee –%s %s.",employee.getFirstName(),employee.getLastName())).append(System.lineSeparator());

            System.out.println();
        }

        return sb.toString();
    }

    @Override
    public String exportTopEmployees() {
        StringBuilder sb=new StringBuilder();
        List<Employee>employees=this.employeeRepository.findAllEmployeesWithClients();
        for (Employee employee : employees) {
            sb.append(String.format("Full Name: %s %s",employee.getFirstName(),employee.getLastName())).append(System.lineSeparator());
            sb.append(String.format("Salary: %s",employee.getSalary())).append(System.lineSeparator());
            sb.append(String.format("Started On: %s",employee.getStartedOn())).append(System.lineSeparator());
            sb.append("Clients:").append(System.lineSeparator());
            for (Client client : employee.getClients()) {
                sb.append(String.format("%s",client.getFullName())).append(System.lineSeparator());
            }


        }

        return sb.toString();
    }
}
