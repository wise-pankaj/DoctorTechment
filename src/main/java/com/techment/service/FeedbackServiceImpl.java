package com.techment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IFeedbackDao;
import com.techment.dto.DoctorDto;
import com.techment.dto.FeedbackDto;
import com.techment.entity.Doctor;
import com.techment.entity.Feedback;
import com.techment.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackDao feedbackdao;
	
	
	@Override
	public String AddFeedback(FeedbackDto feedback) {
		
		
		Feedback newFeed= new Feedback(feedback.getRating(), feedback.getFeedbackComment(), feedback.getPatient(), feedback.getDoctor());
				
		feedbackdao.save(newFeed);
					
		return "Feedback of Patients are added successfully";
	}

	@Override
	public List<FeedbackDto> GetAllFeedback() {
		List<Feedback> feedbacks = feedbackdao.findAll();
		
		List<FeedbackDto> feedbackList = new ArrayList<FeedbackDto>();
		for(Feedback feedback : feedbacks )
		{
			feedbackList.add(new FeedbackDto(feedback.getRating(), feedback.getFeedbackComment(), feedback.getPatient(), feedback.getDoctor()));		
				
		}
		
		
	
		
		return feedbackList;
	}

	
	public FeedbackDto GetFeedbackById(int id) {
		Feedback feedback = feedbackdao.findById(id).get();
		
		FeedbackDto feedbackdto =new FeedbackDto(feedback.getRating(), feedback.getFeedbackComment(), feedback.getPatient(), feedback.getDoctor());
		
		//FeedbackDto feedbackdto= modelMapper.map(feedback,FeedbackDto.class);
		
		return feedbackdto;
	}

	@Override
	public String DeleteFeedbackById(int id) {
		
		feedbackdao.deleteById(id);
		return "Feedback Deleted Successfully";
	}

	@Override
	public String UpdateFeedBack(int id, FeedbackDto feedback) {
		Feedback oldFeedback = feedbackdao.findById(id).get();
		oldFeedback.setFeedbackComment(feedback.getFeedbackComment());
		oldFeedback.setRating(feedback.getRating());
		feedbackdao.save(oldFeedback);
		
		
		
		return "feedback Updated successfully";
	}

	
	

}
