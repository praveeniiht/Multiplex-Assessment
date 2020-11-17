package com.iiht.exceptioncases;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iiht.movie.exception.InsertionFailed;
import com.iiht.movie.exception.ResourceNotFoundException;
import com.iiht.movie.service.AllotmentServiceImpl;
import com.iiht.movie.service.MovieServiceImpl;
import com.iiht.movie.service.MultiplexServiceImpl;
import com.iiht.utiltestclass.MasterData;

class ExceptionTest {
	static {
		File file = new File("output_exception_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_exception_revised.txt"));
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
	}
	
	@InjectMocks
	private MovieServiceImpl movieServiceImpl;

	@InjectMocks
	private MultiplexServiceImpl multiplexServiceImpl;

	@InjectMocks
	private AllotmentServiceImpl allotmentServiceImpl;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testForMovieSave() throws Exception {
		try {
			 movieServiceImpl.saveMovie(MasterData.getMovie());
		} catch (InsertionFailed e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForMovieSave=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForMovieSave=false", true);
			throw e;
		}
		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\ntestForMovieSave=false", true);
	}

	@Test
	public void testForMultiplexSave() throws Exception {
		try {
			 multiplexServiceImpl.saveMultiplex(MasterData.getMultiplex());
		} catch (InsertionFailed e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForMultiplexSave=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForMultiplexSave=false", true);
			throw e;
		}
		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\ntestForMultiplexSave=false", true);
	}
	
	/*
	 * @Test public void testForAllotmentSave() throws Exception { try {
	 * allotmentServiceImpl.saveAllotment(MasterData.getAllotment()); } catch
	 * (InsertionFailed e) { File file = new File("output_exception_revised.txt");
	 * FileUtils.write(file, "\ntestForAllotmentSave=true", true); throw e; } catch
	 * (Exception e) { File file = new File("output_exception_revised.txt");
	 * FileUtils.write(file, "\ntestForAllotmentSave=false", true); throw e; } File
	 * file = new File("output_exception_revised.txt"); FileUtils.write(file,
	 * "\ntestForAllotmentSave=false", true); }
	 */
	
	@Test
	public void testForFindMovieByName() throws Exception {
		try {
			movieServiceImpl.findByMovieName(MasterData.getMovie().getName());
		} catch (ResourceNotFoundException e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForFindMovieByName=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForFindMovieByName=false", true);
			throw e;
		}
		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\ntestForFindMovieByName=false", true);
	}
	
	@Test
	public void testForFindMultiplexByName() throws Exception {
		try {
			multiplexServiceImpl.searchByMultiplex(MasterData.getMultiplex().getName());
		} catch (ResourceNotFoundException e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForFindMultiplexByName=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\ntestForFindMultiplexByName=false", true);
			throw e;
		}
		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\ntestForFindMultiplexByName=false", true);
	}

}
