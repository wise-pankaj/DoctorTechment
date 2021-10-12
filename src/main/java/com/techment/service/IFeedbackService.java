package com.techment.service;

import java.util.List;

import com.techment.dto.FeedbackDto;

public interface IFeedbackService {

	String AddFeedback(FeedbackDto feedback);//Add
	List<FeedbackDto> GetAllFeedback();//View All
	String DeleteFeedbackById(int id);//Delete
	FeedbackDto GetFeedbackById(int id);
	String UpdateFeedBack(int id,FeedbackDto feedback);
	
}
