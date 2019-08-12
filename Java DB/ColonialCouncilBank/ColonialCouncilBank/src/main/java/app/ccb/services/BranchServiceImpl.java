package app.ccb.services;

import app.ccb.domain.dtos.json.BrancheImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.repositories.BranchRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {
    private static final String JSON_BRANCH_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\ColonialCouncilBank\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\branches.json";

    private BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public BranchServiceImpl(BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() != 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(JSON_BRANCH_PATH);
    }

    @Override
    public String importBranches(String branchesJson) {
        StringBuilder sb=new StringBuilder();
        BrancheImportDto[]brancheImportDtos=this.gson.fromJson(branchesJson,BrancheImportDto[].class);

        for (BrancheImportDto brancheImportDto : brancheImportDtos) {
            Branch branch=this.modelMapper.map(brancheImportDto,Branch.class);

            if (!this.validationUtil.isValid(branch)){
                sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            this.branchRepository.saveAndFlush(branch);
            sb.append(String.format("Successfully imported Branch –%s.",branch.getName())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
