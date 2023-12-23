package com.Rtn.dao;



import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Rtn.model.Rtn;
import com.util.HibernateUtil;







public class RtnDAOImpl implements RtnDAO {
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public RtnDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Rtn entity) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(entity);
	}

	@Override
	public int update(Rtn entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer id) {
		Rtn rtnvo = getSession().get(Rtn.class, id);
		if (rtnvo != null) {
			getSession().delete(rtnvo);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public Rtn getById(Integer id) {
		return getSession().get(Rtn.class, id);
	}

	@Override
	public List<Rtn> getAll() {
		return getSession().createQuery("from rtn", Rtn.class).list();
	}

	@Override
	public List<Rtn> getByCompositeQuery(Map<String, String> map) {
		if (map.size() == 0)
			return getAll();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Rtn> criteria = builder.createQuery(Rtn.class);
		Root<Rtn> root = criteria.from(Rtn.class);

		List<Predicate> predicates = new ArrayList<>();

		if (map.containsKey("starthiredate") && map.containsKey("endhiredate"))
			predicates.add(builder.between(root.get("hiredate"), Date.valueOf(map.get("starthiredate")), Date.valueOf(map.get("endhiredate"))));

		if (map.containsKey("startsal") && map.containsKey("endsal"))
			predicates.add(builder.between(root.get("sal"), new BigDecimal(map.get("startsal")), new BigDecimal(map.get("endsal"))));

		for (Map.Entry<String, String> row : map.entrySet()) {
			if ("ename".equals(row.getKey())) {
				predicates.add(builder.like(root.get("ename"), "%" + row.getValue() + "%"));
			}

			if ("job".equals(row.getKey())) {
				predicates.add(builder.equal(root.get("job"), row.getValue()));
			}

			if ("starthiredate".equals(row.getKey())) {
				if (!map.containsKey("endhiredate"))
					predicates.add(builder.greaterThanOrEqualTo(root.get("hiredate"), Date.valueOf(row.getValue())));
			}

			if ("endhiredate".equals(row.getKey())) {
				if (!map.containsKey("starthiredate"))
					predicates.add(builder.lessThanOrEqualTo(root.get("hiredate"), Date.valueOf(row.getValue())));

			}

			if ("startsal".equals(row.getKey())) {
				if (!map.containsKey("endsal"))
					predicates.add(builder.greaterThanOrEqualTo(root.get("sal"), new BigDecimal(row.getValue())));

			}

			if ("endsal".equals(row.getKey())) {
				if (!map.containsKey("startsal"))
					predicates.add(builder.lessThanOrEqualTo(root.get("sal"), new BigDecimal(row.getValue())));

			}

		}

		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("empno")));
		TypedQuery<Rtn> query = getSession().createQuery(criteria);

		return query.getResultList();
	}

	@Override
	public List<Rtn> getAll(int currentPage) {
		int first = (currentPage - 1) * 3;//PAGE_MAX_RESULT;
		return getSession().createQuery("from Emp", Rtn.class)
				.setFirstResult(first)
//				.setMaxResults(PAGE_MAX_RESULT)
				.setMaxResults(3)
				.list();
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
