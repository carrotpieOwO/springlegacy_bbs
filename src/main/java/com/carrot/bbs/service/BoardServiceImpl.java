package com.carrot.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.carrot.bbs.dto.BoardVO;
import com.carrot.bbs.dto.Criteria;
import com.carrot.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardMapper mapper;
	
	
	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insert(board);

	}

	@Override
	public BoardVO selectOne(int bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.update(board);

	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> selectAll(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.listPaging(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		// TODO Auto-generated method stub
		
		return mapper.totalCount(cri);
	}
	
	

}
