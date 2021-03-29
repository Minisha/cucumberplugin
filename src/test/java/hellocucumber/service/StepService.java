package hellocucumber.service;

import hellocucumber.entity.StepEntity;
import hellocucumber.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {

    @Autowired
    private StepRepository stepRepository;

    public void saveStep(StepEntity stepEntity) {
        stepRepository.save(stepEntity);
    }
}
