package dao;

import java.util.List;

import domain.ProjectTeamBean;


public class ProjectTeamDAOImpl implements ProjectTeamDAO{
	private static ProjectTeamDAO instance = new ProjectTeamDAOImpl();
	public static ProjectTeamDAO getInstance() {
		return instance;
	}
	private ProjectTeamDAOImpl() {}
	@Override
	public void insertTeam(ProjectTeamBean pt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectTeamBean> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> selectSomeList(String pt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeamBean selectOneList(String pt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ProjectTeamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProjectTeamBean exam) {
		// TODO Auto-generated method stub
		
	}

}
