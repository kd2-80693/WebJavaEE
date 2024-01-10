package daos;

import java.util.List;

import pojos.Team;

public interface TeamsDao {
	String addTeam(Team t);
	List<Team> getTeamsIdAbrivations();
	Team getTeamDetailsById(Integer id);
	List<Team> getTeamsByMaxAgeAndMinWickets(int maxAge , int minWickets);
	String updateAgeAndAvgByName(String name , int maxAge, double maxBattingAvg);
	String deleteById(Integer id);
}
