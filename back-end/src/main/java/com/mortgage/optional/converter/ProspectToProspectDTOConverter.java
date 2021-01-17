package com.mortgage.optional.converter;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.model.Prospect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ProspectToProspectDTOConverter implements Converter<Prospect, ProspectDTO> {

    @Override
    public ProspectDTO convert(Prospect prospect) {
        return new ProspectDTO(prospect.getFullName(), prospect.getTotalLoan(), prospect.getInterest(), prospect.getYears());
    }
}
