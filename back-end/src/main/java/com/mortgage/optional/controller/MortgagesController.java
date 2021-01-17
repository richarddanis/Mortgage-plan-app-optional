package com.mortgage.optional.controller;

import com.mortgage.optional.dto.ReportDTO;
import com.mortgage.optional.service.ProspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mortgages")
public class MortgagesController {

    private final Logger LOGGER = LoggerFactory.getLogger(MortgagesController.class);
    private final ProspectService prospectService;

    public MortgagesController(ProspectService prospectService) {
        this.prospectService = prospectService;
    }

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getMortgage(){
        try{
            List<ReportDTO> reportDto = prospectService.getMortgageCalculation();
            return new ResponseEntity<>(reportDto, HttpStatus.OK);
        } catch (Exception e){
            LOGGER.error(String.format("Unexpected exception while fetching the prospects exception: %s", e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
