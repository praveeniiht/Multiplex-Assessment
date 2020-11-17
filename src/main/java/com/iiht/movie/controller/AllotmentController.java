package com.iiht.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.movie.dto.AllotmentDTO;
import com.iiht.movie.model.Allotment;
import com.iiht.movie.service.AllotmentService;

@RestController
@RequestMapping("/allot")
public class AllotmentController {

	@Autowired
    private AllotmentService allotmentService;

	@GetMapping(value = "/")
    public List<AllotmentDTO> getAllAllotments() {
        return null;
    }
	
	@GetMapping(value = "/findByMovie/{movieName}")
    public AllotmentDTO getAllotmentByMovieName(@PathVariable("movieName") String movieName) {
        return null;
    }
	
	@GetMapping(value = "/findByMultiplex/{multiplexName}")
    public AllotmentDTO getAllotmentByMultiplexName(@PathVariable("multiplexName") String multiplexName) {
        return null;
    }
	
	@PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateAllotment(@RequestBody AllotmentDTO allotment) {
		return null;
   	}
}
