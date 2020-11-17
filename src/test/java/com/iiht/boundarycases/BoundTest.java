package com.iiht.boundarycases;

import static com.iiht.utiltestclass.TestUtils.boundaryTestFile;
import static com.iiht.utiltestclass.TestUtils.currentTest;
import static com.iiht.utiltestclass.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iiht.movie.dto.MovieDTO;
import com.iiht.movie.dto.MultiplexDTO;
import com.iiht.utiltestclass.MasterData;

class BoundTest {
	private Validator validator;
	@BeforeEach
	void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testMovieNameLength() throws Exception {
		MovieDTO movie = MasterData.getMovie();
		movie.setName("DDLJ");
		Set<ConstraintViolation<MovieDTO>> violations = validator.validate(movie);
		yakshaAssert(currentTest(), 
					 violations.isEmpty()? true : false, 
					 boundaryTestFile);

	}
	
	@Test
	public void testMultiplexNameLength() throws Exception {
		MultiplexDTO multiplex = MasterData.getMultiplex();
		multiplex.setName("WSM");
		Set<ConstraintViolation<MultiplexDTO>> violations = validator.validate(multiplex);
		yakshaAssert(currentTest(), 
					 violations.isEmpty()? true : false, 
					 boundaryTestFile);

	}

}
