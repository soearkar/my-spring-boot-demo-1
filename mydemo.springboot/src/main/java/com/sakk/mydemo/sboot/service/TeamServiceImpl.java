package com.sakk.mydemo.sboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.mydemo.sboot.dao.TeamDao;
import com.sakk.mydemo.sboot.entity.Player;
import com.sakk.mydemo.sboot.entity.Team;
import com.sakk.mydemo.sboot.model.PlayerDTO;
import com.sakk.mydemo.sboot.model.TeamDTO;
import com.sakk.mydemo.sboot.util.CommonConstant;
import com.sakk.mydemo.sboot.util.CommonUtil;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;

	@Autowired
	EntityManager em;

	@Override
	public List<TeamDTO> getList() {
		//List<Team> teams = searchTeam(null);
		/*Pageable pager = PageRequest.of(0, 3);
		Page<Team> teams= teamDao.findAll(pager);*/
		List<Team> teams = teamDao.findAll();
		List<TeamDTO> dtoList = new ArrayList<>();
		for (Team team : teams) {
			dtoList.add(new TeamDTO(team));
		}
		return dtoList;
	}
	
	

	public List<TeamDTO> getListByQurey() {
		Query query = em.createQuery("SELECT t from Team t", Team.class);
		@SuppressWarnings("unchecked")
		List<Team> teams = query.getResultList();
		List<TeamDTO> dtoList = new ArrayList<>();
		for (Team team : teams) {
			dtoList.add(new TeamDTO(team));
		}
		return dtoList;
	}

	@Override
	public TeamDTO findTeamById(long id) {
		return new TeamDTO(teamDao.findById(id));
	}

	@Override
	public TeamDTO saveTeam(TeamDTO teamDTO) {
		try{
		Team team = new Team();
		team.setId(teamDTO.getId());
		team.setFoundedYear(new Date());
		team.setTeamname(teamDTO.getName());
		team.setTotalMatches(0);
		team.setPlayers(new ArrayList<>());
		Player player = null;
		System.out.println("Siz >>>>> "+teamDTO.getPlayers().size());
		for (PlayerDTO playerDTO : teamDTO.getPlayers()) {
			player = new Player();
			player.setId(playerDTO.getId());
			player.setDateOfBirth(CommonUtil.changeStringToDate(CommonConstant.STD_DATE_FORMAT, playerDTO.getDob()));
			player.setName(playerDTO.getName());
			player.setAddress(playerDTO.getAddress());
			player.setTotalMatches(0);
			player.setTeam(team);
			team.getPlayers().add(player);
		}
		teamDao.saveAndFlush(team);
		return new TeamDTO(team);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteTeam(long id) {
        try{
		Query query = em.createQuery(" DELETE  from Team t WHERE id=:id ");
		query.setParameter("id", id);
		int effectdRow = query.executeUpdate();
		if(effectdRow > 0){
			return true;
		}
		// teamDao.deleteById(id);
        }catch(Exception ex){
        	return false;
        }
		return false;
	}



	public List<Team> searchTeam(Map<String, Object> params) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Team> cq= cb.createQuery(Team.class);
		Root<Team> from = cq.from(Team.class);
		List<Predicate> predicates = new ArrayList<>();	
		Predicate predName= cb.or(cb.like(from.get("teamname"), "%Team%"),cb.like(from.get("teamname"), "%Shan%"));
		Predicate predId= cb.or(cb.greaterThan(from.get("id"), 2));
		Predicate predNot= cb.not(cb.equal(from.get("id"), 3));
		
		/*Predicate predDis = cb.disjunction(); // and 0=1
		Predicate predCon = cb.conjunction(); // and 1=1
		Predicate predMid = cb.or();*/
		
		//predicates.add(predName);
	    //predicates.add(predId);
	    //predicates.add(predNot);
		
		cq.select(from).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))); // and
		//cq.select(from).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));  // or
		
		//from.join("players",JoinType.LEFT).alias("P");
		/*cq.groupBy(from.get("teamname"));
		cq.having(cb.greaterThan(from.get("id"), 1));
		cq.orderBy(cb.asc(from.get("teamname")),cb.desc(from.get("id")));*/
		
		TypedQuery<Team> query = em.createQuery(cq);
		/*query.setFirstResult((2-1) * 1);  //pagination
		query.setMaxResults(1);*/
		
		return  query.getResultList();
	}

}
