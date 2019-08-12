package alararestaurant.service;
import alararestaurant.domain.dtos.jsonDtos.EmployeeDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String EMPLOYEES_JSON_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\Alara Restaurant 11\\AlaraRestaurant\\src\\main\\resources\\files\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.positionRepository = positionRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return fileUtil.readFile(EMPLOYEES_JSON_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder sb=new StringBuilder();

        EmployeeDto[]employeeDtos=this.gson.fromJson(employees,EmployeeDto[].class);
        for (EmployeeDto employeeDto : employeeDtos) {
            Employee employee=this.modelMapper.map(employeeDto,Employee.class);
            if(!this.validationUtil.isValid(employee)){
                sb.append("Invalid data format.").append(System.lineSeparator());

                continue;
            }

            Position position=this.positionRepository.findByName(employeeDto.getPosition());
            if (position==null){
                position=new Position();
                position.setName(employeeDto.getPosition());

                if (!this.validationUtil.isValid(position)){
                    sb.append("Invalid date format").append(System.lineSeparator());

                    continue;
                }

                this.positionRepository.saveAndFlush(position);
            }
            employee.setPosition(position);
            this.employeeRepository.saveAndFlush(employee);
            sb.append(String.format("Record %s successfully imported.",employee.getName()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
