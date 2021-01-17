package com.mortgage.optional.converter;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.model.Prospect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProspectDTOToProspectConverter implements Converter<ProspectDTO, Optional<Prospect>> {

    @Override
    public Optional<Prospect> convert(ProspectDTO prospectDTO) {
        return Optional.of(new Prospect(prospectDTO.getFullName(), prospectDTO.getTotalLoan(), prospectDTO.getInterest(), prospectDTO.getYears()));
    }
}
