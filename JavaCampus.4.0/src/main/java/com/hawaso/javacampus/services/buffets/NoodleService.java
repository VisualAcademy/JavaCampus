package com.hawaso.javacampus.services.buffets;

import com.hawaso.javacampus.models.buffets.Noodle;
import com.hawaso.javacampus.repositories.buffets.NoodleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoodleService {

    @Autowired
    private NoodleRepository noodleRepository;

    public List<Noodle> getAllNoodles() {
        return noodleRepository.findAll();
    }

    public Noodle getNoodleById(int id) {
        return noodleRepository.findById(id).orElse(null);
    }

    public Noodle saveNoodle(Noodle noodle) {
        return noodleRepository.save(noodle);
    }

    public void deleteNoodle(int id) {
        noodleRepository.deleteById(id);
    }
}
