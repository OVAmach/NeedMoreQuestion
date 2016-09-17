package com.iteamcn.NeedMoreQuestion;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;

import com.iteamcn.NeedMoreQuestion.obj.*;

public class NeedMoreQuestion extends JavaPlugin {
	private static Map<String,Questionnaire> QuestionnaireList=new HashMap<>();
	public void onEnable(){
		loadAll();
		getCommand("nmq").setExecutor(new Commands());
		getCommand("question").setExecutor(new Commands());
		getCommand("q").setExecutor(new Commands());
	}
	private void loadAll(){
		checkConfig();
		loadQuestionnaireList(false);
	}
	private void checkConfig(){
		if(!getDataFolder().exists()) {
			  getDataFolder().mkdir();
		}
		File config=new File(getDataFolder(),"config.yml");
		if (!(config.exists())) {saveDefaultConfig();}
		reloadConfig();
	}
	private void loadQuestionnaireList(boolean defaultValue){
		try{
			QuestionnaireList.clear();
			Set<String> QNL = getConfig().getConfigurationSection("QuestionnaireList").getKeys(false);
			for(String i:QNL){
				int TestQuestionAmount=getConfig().getInt("QuestionnaireList."+i+".Settings.TestQuestionAmount");
				boolean RandomQuestion=getConfig().getBoolean("QuestionnaireList."+i+".Settings.RandomQuestion");
				long Delay=getConfig().getLong("QuestionnaireList."+i+".Settings.Delay");
				List<String> CompleteTips=getConfig().getStringList("QuestionnaireList."+i+".Settings.CompleteTips");
				List<String> CompleteCommands=getConfig().getStringList("QuestionnaireList."+i+".Settings.CompleteCommands");
				String IfHasWrong=getConfig().getString("QuestionnaireList."+i+".Settings.IfHasWrong");
				QuestionnaireSetting QS = new QuestionnaireSetting(TestQuestionAmount,RandomQuestion,Delay,CompleteTips,CompleteCommands,IfHasWrong);
				//############
				Set<String> Qs = getConfig().getConfigurationSection("QuestionnaireList."+i+".Questions").getKeys(false);
				List<Question> Questions=new ArrayList<Question>();
				for(String j:Qs){
					String QuestionTitle=getConfig().getString("QuestionnaireList."+i+".Questions."+j+".QuestionTitle");
					String Questionid=getConfig().getString("QuestionnaireList."+i+".Questions."+j+".Questionid");
					boolean RandomAnswer=getConfig().getBoolean("QuestionnaireList."+i+".Questions."+j+".RandomAnswer");
					boolean MultiSelect=getConfig().getBoolean("QuestionnaireList."+i+".Questions."+j+".MultiSelect");
					int MultiSelectAmount=getConfig().getInt("QuestionnaireList."+i+".Questions."+j+".MultiSelectAmount");
					String Answerid=getConfig().getString("QuestionnaireList."+i+".Questions."+j+".Answerid");
					List<String> RightAnswer=getConfig().getStringList("QuestionnaireList."+i+".Questions."+j+".RightAnswer");
					List<String> WrongAnswer=getConfig().getStringList("QuestionnaireList."+i+".Questions."+j+".WrongAnswer");
					List<String> RightCommand=getConfig().getStringList("QuestionnaireList."+i+".Questions."+j+".RightCommand");
					List<String> WrongCommand=getConfig().getStringList("QuestionnaireList."+i+".Questions."+j+".WrongCommand");
					Questions.add(new Question(QuestionTitle,Questionid,RandomAnswer,MultiSelect,MultiSelectAmount,Answerid,RightAnswer,WrongAnswer,RightCommand,WrongCommand));
					getLogger().info(QuestionTitle);
				}
				QuestionnaireList.put(i, new Questionnaire(QS,new QuestionnaireQuestion(Questions)));
			}
			getLogger().info("问卷已经读取完毕,共"+QuestionnaireList.size()+"份问卷");
		}catch(Exception e){
			if(!defaultValue){
				File oldfile=new File(getDataFolder(),"config.yml");
				File newfile=new File(getDataFolder(),"config"+new Date().getTime()+".yml");
				oldfile.renameTo(newfile);
				checkConfig();
				loadQuestionnaireList(true);
				getLogger().info("配置文件有误，从jar中读入初始配置文件");
			}else{
				getLogger().info("初始配置文件有误,无法从jar中读取正确的配置文件");
			}
		}
	}
	public static Questionnaire getQuestionnaire(String id){
		return QuestionnaireList.get(id);
	}
}