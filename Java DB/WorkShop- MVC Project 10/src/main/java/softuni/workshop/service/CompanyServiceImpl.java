package softuni.workshop.service;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Override
    public void importCompanies() {
        //TODO seed in database
    }

    @Override
    public boolean areImported() {
        //TODO check if repository has any records
        return false;
    }

    @Override
    public String readCompaniesXmlFile() {
        //TODO READ XML FILE
        return null;
    }
}
