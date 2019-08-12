package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.xml.pictures.PictureImportDto;
import softuni.exam.domain.dtos.xml.pictures.PictureImportRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_XML_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\db-exam\\src\\main\\resources\\files\\xml\\pictures.xml";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public String importPictures() throws JAXBException {
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(PictureImportRootDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        PictureImportRootDto pictureImportRootDto= (PictureImportRootDto) unmarshaller.unmarshal(new File(PICTURE_XML_PATH));

        for (PictureImportDto pictureImportDto : pictureImportRootDto.getPictureImportDtos()) {
            Picture picture=this.modelMapper.map(pictureImportDto,Picture.class);

            if (!this.validatorUtil.isValid(picture)){
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            this.pictureRepository.saveAndFlush(picture);
            sb.append(String.format("Successfully imported picture- %s",picture.getUrl())).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count()>0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return this.fileUtil.readFile(PICTURE_XML_PATH);
    }

}
