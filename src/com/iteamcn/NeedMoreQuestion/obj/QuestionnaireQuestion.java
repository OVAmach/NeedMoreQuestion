package com.iteamcn.NeedMoreQuestion.obj;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireQuestion {
	private List<Question> Questions=new ArrayList<Question>();
	public QuestionnaireQuestion(List<Question> Questions){
		this.Questions=Questions;
	}
	public List<Question> getQuestionList(){
		return this.Questions;
	}
	public void setQuestionList(List<Question> Questions){
		this.Questions=Questions;
	}
}
