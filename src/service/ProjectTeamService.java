package service;

import java.util.List;

import domain.ProjectTeamBean;

public interface ProjectTeamService {
	public void createScore(String word);
	public List<ProjectTeamBean> showAllList();
	public List<ProjectTeamBean> showSomeList(String word);
	public ProjectTeamBean showOneList(String word);
	public int showCountList();
	public void modifyProjectTeam(String word);
	public void removeProjectTeam(String word);
}
