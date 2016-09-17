package com.iteamcn.NeedMoreQuestion.obj;

public class Questionnaire {
	private QuestionnaireSetting Settings;
	private QuestionnaireQuestion Questions;
	public Questionnaire(QuestionnaireSetting Settings,QuestionnaireQuestion Questions){
		this.Settings=Settings;
		this.Questions=Questions;
	}
	public QuestionnaireSetting getSettings(){
		return this.Settings;
	}
	public void setSettings(QuestionnaireSetting Setting){
		this.Settings=Setting;
	}
	public QuestionnaireQuestion getQuestions(){
		return this.Questions;
	}
	public void setQuestions(QuestionnaireQuestion Questions){
		this.Questions=Questions;
	}
}
