package com.sakk.mydemo.sboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.mydemo.sboot.model.TeamDTO;
import com.sakk.mydemo.sboot.response.ApiResponse;
import com.sakk.mydemo.sboot.service.TeamService;
import com.sakk.mydemo.sboot.util.CommonConstant.MessageStatus;

@RestController
@RequestMapping("/v1/team")
public class TeamController extends MainController{
	
	@Autowired
	TeamService teamService;

	@GetMapping(value = "/list")
	public ApiResponse<List<TeamDTO>> getList(HttpServletRequest request) {
		return new ApiResponse<List<TeamDTO>>("1",MessageStatus.SUCCESS.getDesc(),teamService.getList());
	}

	@GetMapping(value = "/{id}")
	public TeamDTO getTeam(@PathVariable("id") long id, HttpServletRequest request) {
		return teamService.findTeamById(id);
	}
	
	@PostMapping(value = "/save")
	public ApiResponse<TeamDTO> saveTeam(@RequestBody TeamDTO teamDTO,HttpServletRequest request) {
		TeamDTO result = teamService.saveTeam(teamDTO);
		if(result != null && result.getId() > 0){
			return new ApiResponse<TeamDTO>(MessageStatus.SUCCESS.getCode()+"",MessageStatus.SUCCESS.getDesc(),result);	
		}
		return new ApiResponse<TeamDTO>(MessageStatus.FAIL.getCode()+"",MessageStatus.FAIL.getDesc(),new TeamDTO());
	}
	
	@PostMapping(value = "/delete")
	public ApiResponse<TeamDTO> deleteTeam(@RequestBody Map<String,String> params,HttpServletRequest request) {
		if(teamService.deleteTeam(Long.parseLong(params.get("id")))){
			return new ApiResponse<TeamDTO>("1",MessageStatus.SUCCESS.getDesc(),new TeamDTO());
		}else{
			return new ApiResponse<TeamDTO>("-1",MessageStatus.FAIL.getDesc(),new TeamDTO());
		}
	}
}
