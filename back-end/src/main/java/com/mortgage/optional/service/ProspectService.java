package com.mortgage.optional.service;

import com.mortgage.optional.calculator.MortgageCalculator;
import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.dto.ReportDTO;
import com.mortgage.optional.exception.EntityNotFoundException;
import com.mortgage.optional.model.Prospect;
import com.mortgage.optional.repository.ProspectRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProspectService{

    private final ProspectRepository repository;
    private final ConversionService conversionService;
    private final MortgageCalculator mortgageCalculator;

    public ProspectService(ProspectRepository repository,
                           ConversionService conversionService,
                           MortgageCalculator mortgageCalculator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.mortgageCalculator = mortgageCalculator;
    }

    public ProspectDTO save(ProspectDTO prospect) {
        return Optional.ofNullable(conversionService.convert(prospect, Prospect.class))
                .map(repository::save)
                .map(savedProspect -> conversionService.convert(savedProspect, ProspectDTO.class))
                .orElseThrow(() -> new EntityNotFoundException("Cannot save the prospect entity: " + prospect));
    }

    public List<ReportDTO> getMortgageCalculation() {
        return repository.findAllByOrderByCreateDateDesc()
                .stream()
                .map(mortgageCalculator::calculateAndGenerateReport)
                .collect(Collectors.toList());
    }
}
