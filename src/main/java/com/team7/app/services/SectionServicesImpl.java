package com.team7.app.services;

import com.team7.app.business.dto.SectionDto;
import com.team7.app.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServicesImpl implements SectionServices {

    private SectionRepository sectionRepository;

    @Autowired
    public void setSectionRepository(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }
    @Override
    public Iterable<SectionDto> listAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public SectionDto getSectionById(Integer id) {
        return sectionRepository.findOne(id);
    }

    @Override
    public SectionDto saveSection(SectionDto section) {
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Integer id) {
        sectionRepository.delete(id);
    }
}
