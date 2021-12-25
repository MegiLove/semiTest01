package com.sist.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.LocationDAO;
import com.sist.vo.LocationVO;
public class showLocAction implements SistAction {
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocationDAO dao = new LocationDAO();
		ArrayList<LocationVO> list = dao.listAll();
		HashMap<String,ArrayList<String>> districts = new HashMap<String,ArrayList<String>>();
		HashMap<String,ArrayList<String>> dongs = new HashMap<String,ArrayList<String>>();
		
		ArrayList<String> provinces = dao.getProvince();
		System.out.println(provinces.toString());
		for(LocationVO l : list) {
			if(districts.get(l.getProvince())==null) {
				districts.put(l.getProvince(), dao.getDistrict(l.getProvince()));
			}
		}
		for(LocationVO l : list) {
			if(dongs.get(l.getDistrict())==null) {
				dongs.put(l.getDistrict(), dao.getDong(l.getDistrict()));
			}
		}
		System.out.println(dongs.toString());
		
		request.setAttribute("provinces", provinces);
		request.setAttribute("districts", districts);
		request.setAttribute("dongs", dongs);
		
		
		return "showLoc.jsp";
	}
	
}