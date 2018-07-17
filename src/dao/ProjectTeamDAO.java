package dao;

import java.util.List;

import domain.ProjectTeamBean;

public interface ProjectTeamDAO {
	public void insertTeam(ProjectTeamBean pt);
	public List<ProjectTeamBean> selectList();
	public List<ProjectTeamBean> selectSomeList(String pt);
	public ProjectTeamBean selectOneList(String pt);
	public int countAccount();
	public void update(ProjectTeamBean exam);
	public void delete(ProjectTeamBean exam);
}
