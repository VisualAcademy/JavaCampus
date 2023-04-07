package com.hawaso.javacampus.services.buffets;

import com.hawaso.javacampus.models.buffets.Broth;
import com.hawaso.javacampus.repositories.buffets.BrothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothService {

    @Autowired
    private BrothRepository brothRepository;

    public List<Broth> getAllBroths() {
        return brothRepository.findAll();
    }

    public Broth getBrothById(int id) {
        return brothRepository.findById(id).orElse(null);
    }

    public Broth saveBroth(Broth broth) {
        return brothRepository.save(broth);
    }

    public void deleteBroth(int id) {
        brothRepository.deleteById(id);
    }
}
