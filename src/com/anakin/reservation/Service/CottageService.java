package com.anakin.reservation.Service;

import com.anakin.reservation.DAO.CottageDAO;
import com.anakin.reservation.VO.CottageVO;

public class CottageService {

	CottageDAO cottageDAO;
	
	public CottageVO selectCottageByNamesService(String cottage_name) {
		return cottageDAO.selectCottageByName(cottage_name);
	}
	
}
