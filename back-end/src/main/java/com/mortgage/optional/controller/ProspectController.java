package com.mortgage.optional.controller;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.service.ProspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/prospects")
@Validated
@CrossOrigin
public class ProspectController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProspectController.class);
    private final ProspectService prospectService;

    public ProspectController(ProspectService prospectService) {
        this.prospectService = prospectService;
    }

    @PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProspectDTO> addNewProspect(@Valid @RequestBody ProspectDTO prospectDTO){
        try{
            final ProspectDTO savedProspect = prospectService.save(prospectDTO);
            return new ResponseEntity<>(savedProspect, HttpStatus.OK);
        } catch (Exception e){
            LOGGER.error(String.format("Unexpected exception while save the prospect: %s exception: %s", prospectDTO, e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
