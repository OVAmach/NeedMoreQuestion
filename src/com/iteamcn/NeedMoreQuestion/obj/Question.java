package com.iteamcn.NeedMoreQuestion.obj;

import java.util.List;

public class Question {
	private String QuestionTitle;
	private String Questionid;
	private boolean RandomAnswer;
	private boolean MultiSelect;
	private int MultiSelectAmount;
	private String Answerid;
	private List<String> RightAnswer;
	private List<String> WrongAnswer;
	private List<String> RightCommand;
	private List<String> WrongCommand;
	public Question(String QuestionTitle,String Questionid,boolean RandomAnswer,boolean MultiSelect,int MultiSelectAmount,String Answerid,List<String> RightAnswer,
			List<String> WrongAnswer,List<String> RightCommand,List<String> WrongCommand){
		this.QuestionTitle=QuestionTitle;
		this.Questionid=Questionid;
		this.RandomAnswer=RandomAnswer;
		this.MultiSelect=MultiSelect;
		this.MultiSelectAmount=MultiSelectAmount;
		this.Answerid=Answerid;
		this.RightAnswer=RightAnswer;
		this.WrongAnswer=WrongAnswer;
		this.RightCommand=RightCommand;
		this.WrongCommand=WrongCommand;
	}
	public String getQuestionTitle(){
		return this.QuestionTitle;
	}
	public String getQuestionid(){
		return this.Questionid;
	}
	public boolean getRandomAnswer(){
		return this.RandomAnswer;
	}
	public boolean getMultiSelect(){
		return this.MultiSelect;
	}
	public int getMultiSelectAmount(){
		return this.MultiSelectAmount;
	}
	public String getAnswerid(){
		return this.Answerid;
	}
	public List<String> getRightAnswer(){
		return this.RightAnswer;
	}
	public List<String> getWrongAnswer(){
		return this.WrongAnswer;
	}
	public List<String> getRightCommand(){
		return this.RightCommand;
	}
	public List<String> getWrongCommand(){
		return this.WrongCommand;
	}
}
