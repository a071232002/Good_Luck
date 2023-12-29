package com.product.model;

import java.time.LocalDateTime;
import java.util.List;

public class ProService {

	private ProDAO_interface dao;

	public ProService() {
		dao = new ProDAO();
	}

	public ProVO addProduct(String proName, String proMean, int proPrice, int proQty, byte[] proImg,
			LocalDateTime proCreateTime, int proStatus, int tagNo, int empNo) {

		ProVO proVO = new ProVO();

		proVO.setProName(proName);
		proVO.setProMean(proMean);
		proVO.setProPrice(proPrice);
		proVO.setProQty(proQty);
		proVO.setProImg(proImg);
		proVO.setProCreateTime(proCreateTime);
		proVO.setProStatus(proStatus);
		proVO.setTagNo(tagNo);
		proVO.setEmpNo(empNo);

		dao.insert(proVO);

		return proVO;
	}

	public ProVO updateProduct(Integer proNo, String proName, String proMean, Integer proPrice, Integer proQty, byte[] proImg,
			LocalDateTime proCreateTime, Integer proStatus, Integer tagNo, Integer empNo) {

		ProVO proVO = new ProVO();

		proVO.setProNo(proNo);
		proVO.setProName(proName);
		proVO.setProMean(proMean);
		proVO.setProPrice(proPrice);
		proVO.setProQty(proQty);
		proVO.setProImg(proImg);
		proVO.setProCreateTime(proCreateTime);
		proVO.setProStatus(proStatus);
		proVO.setTagNo(tagNo);
		proVO.setEmpNo(empNo);

		dao.update(proVO);

		return proVO;
	}

	public void deleteProduct(Integer proNo) {
		dao.delete(proNo);
	}

	public ProVO getOneProduct(Integer proNo) {
		return dao.findByPrimaryKey(proNo);
	}

	public List<ProVO> getAll() {
		return dao.getAll();
	}
}