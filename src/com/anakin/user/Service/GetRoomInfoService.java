package com.anakin.user.Service;

import java.util.List;

import com.anakin.user.DAO.GetRoomInfoDAO;
import com.anakin.user.VO.Cottage_roomVO;
import com.anakin.user.VO.SearchConditionVO;

public class GetRoomInfoService {
	GetRoomInfoDAO dao = new GetRoomInfoDAO();
	
	public List<Cottage_roomVO> selectRoomByCottageId(SearchConditionVO scVO,int cottage_id){
		return dao.selectRoomByCottageId(scVO, cottage_id);
	}
}
