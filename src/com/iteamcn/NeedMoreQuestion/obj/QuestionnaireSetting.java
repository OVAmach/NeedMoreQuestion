package com.iteamcn.NeedMoreQuestion.obj;

import java.util.List;

public class QuestionnaireSetting {
	private int TestQuestionAmount;
	private boolean RandomQuestion;
	private long Delay;
	private List<String> CompleteTips;
	private List<String> CompleteCommands;
	private String IfHasWrong;
	public QuestionnaireSetting(int TestQuestionAmount,boolean RandomQuestion,long Delay,List<String> CompleteTips,List<String> CompleteCommands,String IfHasWrong){
		this.TestQuestionAmount=TestQuestionAmount;
		this.RandomQuestion=RandomQuestion;
		this.Delay=Delay;
		this.CompleteTips=CompleteTips;
		this.CompleteCommands=CompleteCommands;
		this.IfHasWrong=IfHasWrong;
	}
	public int getTestQuestionAmount(){
		return this.TestQuestionAmount;
	}
	public boolean getRandomQuestion(){
		return this.RandomQuestion;
	}
	public long getDelay(){
		return this.Delay;
	}
	public List<String> getCompleteTips(){
		return this.CompleteTips;
	}
	public List<String> getCompleteCommands(){
		return this.CompleteCommands;
	}
	public String getIfHasWrong(){
		return this.IfHasWrong;
	}
}
