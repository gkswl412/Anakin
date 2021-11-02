package com.anakin.user.Service;
import java.util.List;
import com.anakin.user.DAO.SearchDAO;
import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

public class SearchService {
	SearchDAO dao = new SearchDAO();
	public List<SearchResultVO> selectByArea(SearchConditionVO scVO){
		return dao.selectByArea(scVO);
	}
	public List<SearchResultVO> sortCottageList(SearchConditionVO scVO, String whatSort) {
		return dao.sortCottageList(scVO, whatSort);
	}
}
