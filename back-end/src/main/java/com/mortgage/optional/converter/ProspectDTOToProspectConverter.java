package com.mortgage.optional.converter;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.model.Prospect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ProspectDTOToProspectConverter implements Converter<ProspectDTO, Prospect> {

    @Override
    public Prospect convert(ProspectDTO prospectDTO) {
        return new Prospect(prospectDTO.getFullName(), prospectDTO.getTotalLoan(), prospectDTO.getInterest(), prospectDTO.getYears());
    }
}
