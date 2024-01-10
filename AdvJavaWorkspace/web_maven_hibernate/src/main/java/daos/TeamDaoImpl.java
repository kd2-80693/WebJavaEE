package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

import static utils.HibernateUtils.getFactory;;

public class TeamDaoImpl implements TeamsDao {

	@Override
	public String addTeam(Team t) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Serializable s = session.save(t);
			tx.commit();
			return "The Team is added on team_id = " + s;
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}

	@Override
	public List<Team> getTeamsIdAbrivations() {
		List<Team> teamList = null; 
		String jpql = "select new pojos.Team(id , abbrevation) from Team t";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			
			teamList = session.createQuery(jpql , Team.class).getResultList();
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
		System.out.println(teamList);
		return teamList;
	}

	@Override
	public Team getTeamDetailsById(Integer id) {
		Team team = null; 
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			team = session.get(Team.class, id);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public List<Team> getTeamsByMaxAgeAndMinWickets(int maxAge, int minWickets) {
		List<Team> teamList = null; 
		String jpql = "select t from Team t where t.maxAge < :maxAge and t.wicketsTaken > :minWickets";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			teamList = session.createQuery(jpql , Team.class).setParameter("maxAge", maxAge).setParameter("minWickets", minWickets)
					.getResultList();
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		return teamList;
	}

	@Override
	public String updateAgeAndAvgByName(String name, int maxAge, double maxBattingAvg) {
		String msg = "Update Failed"; 
		String jpql = "select t from Team t where t.name = :name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Team team = session.createQuery(jpql , Team.class).setParameter("name", name).getSingleResult();
			team.setMaxAge(maxAge);
			team.setBattingAvg(maxBattingAvg);
			tx.commit();
			msg = "Update team => " + team;
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteById(Integer id) {
		String msg = "Delete Failed"; 
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Team team = session.get(Team.class, id);
			session.delete(team);
			tx.commit();
			msg = "Deleted team => " + team;
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		return msg;
	}

	
}
