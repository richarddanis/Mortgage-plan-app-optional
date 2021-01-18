package com.mortgage.optional.config;

import com.mortgage.optional.converter.ProspectDTOToProspectConverter;
import com.mortgage.optional.converter.ProspectToProspectDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConverterConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new ProspectDTOToProspectConverter());
        conversionService.addConverter(new ProspectToProspectDTOConverter());
        return conversionService;
    }
}
