package com.iteamcn.NeedMoreQuestion;

import java.util.Collections;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import com.iteamcn.NeedMoreQuestion.obj.*;

public class InvHolder implements InventoryHolder {
	private int index;
	private Questionnaire Questionnaire;
	public Inventory getInventory() {
		return null;
	}
	public InvHolder(String id){
		this.index=0;
		this.Questionnaire=NeedMoreQuestion.getQuestionnaire(id);
		if(this.Questionnaire.getSettings().getRandomQuestion()){
			Collections.shuffle(this.Questionnaire.getQuestions().getQuestionList());
		}
		if(this.Questionnaire.getSettings().getTestQuestionAmount()>this.Questionnaire.getQuestions().getQuestionList().size()){
			this.Questionnaire.getQuestions().setQuestionList(this.Questionnaire.getQuestions().getQuestionList().subList(0, this.Questionnaire.getSettings().getTestQuestionAmount()));
		}
	}
	public int getIndex(){
		return this.index;
	}
	public Questionnaire getQuestionnaire(){
		return this.Questionnaire;
	}

}
