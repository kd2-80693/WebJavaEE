package beans;

import java.util.List;

import daos.TeamDaoImpl;
import daos.TeamsDao;
import pojos.Team;

public class TeamBean {
	private TeamsDao teamDao;

	public TeamBean() {
		teamDao = new TeamDaoImpl();
		System.out.println("Initialized a Dao Instance");
	}
	public List<Team> getTeams()
	{
		System.out.println("Inside Bean");
		List<Team> list = teamDao.getTeamsIdAbrivations();
		System.out.println("Data colllected : ");
		System.out.println(list);
		return list;
	}
	
	
}
