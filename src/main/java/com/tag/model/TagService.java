package com.tag.model;


import java.util.List;
import java.util.Set;

import com.product.model.ProVO;

public class TagService {

	private TagDAO_interface dao;


    public TagService() {
        dao = new TagDAO();
    }

    public List<TagVO> getAll() {
        return dao.getAll();
    }

    public TagVO getOneTag(Integer tagNo) {
        return dao.findByPrimaryKey(tagNo);
    }

	public Set<ProVO> getProsByTagno(Integer tagNo) {
		return dao.getProsByTagNo(tagNo);
	}

	public void deletePro(Integer tagNo) {
		dao.delete(tagNo);
	}
}

