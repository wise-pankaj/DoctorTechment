package com.techment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.FeedbackDto;
import com.techment.entity.Feedback;
import com.techment.exception.NotFound;
import com.techment.service.IFeedbackService;

@RestController
@RequestMapping(value = "/feedbackController")
public class FeedbackController {

	@Autowired
	IFeedbackService feedbackService;

	@PostMapping(value = "/addFeedback")
	public ResponseEntity<String> addnewFeedback(@RequestBody FeedbackDto feedback) {
		feedbackService.AddFeedback(feedback);
		return new ResponseEntity<String>("Added Sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewFeedback/{id}")
	public ResponseEntity<FeedbackDto> ViewFeedbackById(@PathVariable int id) {
		
		
		try {
			return new ResponseEntity<FeedbackDto>(feedbackService.GetFeedbackById(id),HttpStatus.OK);
		}catch(Exception e)
		{throw new NotFound("feedback not found");
			
		}
		
	}
	
	
	@GetMapping("/viewAllFeedback")
	public ResponseEntity<List<FeedbackDto>> viewAllFeedback(){
		
		try {
			return new ResponseEntity<List<FeedbackDto>>(feedbackService.GetAllFeedback(),HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	

	@PutMapping("/updateFeedback/{id}")
	public ResponseEntity<String> ViewFeedbackById(@PathVariable int id, @RequestBody FeedbackDto feedback) {
		try {

			feedbackService.UpdateFeedBack(id, feedback);
			return new ResponseEntity<String>("Client Updated", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new NotFound("feedback not found");

		}

	}

	@DeleteMapping("/deleteFeedback/{id}")
	public ResponseEntity<String> DeleteFeedbackById(@PathVariable int id) {
		try {
			feedbackService.DeleteFeedbackById(id);
			return new ResponseEntity<String>("Feedback Deleted Successfully", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new NotFound("feedback not found");
		}

	}
}
