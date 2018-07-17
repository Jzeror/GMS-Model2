package service;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService {
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {
		return instance;
	}
	private ProjectTeamServiceImpl() {}
	@Override
	public void createScore(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> showAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> showSomeList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean showOneList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int showCountList() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyProjectTeam(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeProjectTeam(String word) {
		// TODO Auto-generated method stub
		
	}
}
