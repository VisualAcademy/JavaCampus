package com.hawaso.javacampus.services.buffets;

import com.hawaso.javacampus.models.buffets.Garnish;
import com.hawaso.javacampus.repositories.buffets.GarnishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarnishService {

    @Autowired
    private GarnishRepository garnishRepository;

    public List<Garnish> getAllGarnishes() {
        return garnishRepository.findAll();
    }

    public Garnish getGarnishById(int id) {
        return garnishRepository.findById(id).orElse(null);
    }

    public Garnish saveGarnish(Garnish garnish) {
        return garnishRepository.save(garnish);
    }

    public void deleteGarnish(int id) {
        garnishRepository.deleteById(id);
    }
}
