package app.service.impl;
import app.model.Family;
import app.repository.FamilyRepository;
import app.service.FamilyService;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lxb
 * @Date: 2018/12/26 0026
 * @Description:
 */
@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;
    @Override
    public List<Family> toId(int id) {
        return familyRepository.findAllByIdOrderByCreateDateDesc(id);
    }
}
