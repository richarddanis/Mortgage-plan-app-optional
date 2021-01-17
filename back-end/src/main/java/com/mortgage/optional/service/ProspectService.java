package com.mortgage.optional.service;

import com.mortgage.optional.calculator.MortgageCalculator;
import com.mortgage.optional.converter.ProspectDTOToProspectConverter;
import com.mortgage.optional.converter.ProspectToProspectDTOConverter;
import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.dto.ReportDTO;
import com.mortgage.optional.exception.EntityNotFoundException;
import com.mortgage.optional.repository.ProspectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProspectService{

    private final ProspectRepository repository;
    private final ProspectDTOToProspectConverter prospectDTOToProspectConverter;
    private final ProspectToProspectDTOConverter prospectToProspectDTOConverter;
    private final MortgageCalculator mortgageCalculator;

    public ProspectService(ProspectRepository repository,
                           ProspectDTOToProspectConverter prospectDTOToProspectConverter,
                           ProspectToProspectDTOConverter prospectToProspectDTOConverter,
                           MortgageCalculator mortgageCalculator) {
        this.repository = repository;
        this.prospectDTOToProspectConverter = prospectDTOToProspectConverter;
        this.prospectToProspectDTOConverter = prospectToProspectDTOConverter;
        this.mortgageCalculator = mortgageCalculator;
    }

    public ProspectDTO save(ProspectDTO prospect) {
        return Objects.requireNonNull(prospectDTOToProspectConverter.convert(prospect))
                .map(repository::save)
                .map(prospectToProspectDTOConverter::convert)
                .orElseThrow(() -> new EntityNotFoundException("Cannot save the prospect entity: " + prospect));
    }

    public List<ReportDTO> getMortgageCalculation() {
        return repository.findAllByOrderByCreateDateDesc()
                .stream()
                .map(mortgageCalculator::calculateAndGenerateReport)
                .collect(Collectors.toList());
    }
}
