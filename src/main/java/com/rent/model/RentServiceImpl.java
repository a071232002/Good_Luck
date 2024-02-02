package com.rent.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldd.model.Ldd;



@Service("rentService")
public class RentServiceImpl implements RentService{
	@Autowired
	RentRepository repository;
 	@Autowired
 	EntityManager entityManager;


	public void addRent(Rent rent) {
		repository.save(rent);
	}

	public void updateRent(Rent rent) {
		repository.save(rent);
	}


	public Rent getOneRent(Integer rentNo) {
		Optional<Rent> optional = repository.findById(rentNo);
		return optional.orElse(null);
	}

	public List<Rent> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Rent> getAllByLdd(Ldd ldd) {
		// TODO Auto-generated method stub
		return repository.findByLdd(ldd);
	}

	@Override
	public List<Rent> getByCompositeQuery(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> criteriaQuery = criteriaBuilder.createQuery(Rent.class);
        Root<Rent> root = criteriaQuery.from(Rent.class);
        List<Predicate> predicates = new ArrayList<>();
        ArrayList<String> rentRentBetween = new ArrayList<>();
//        System.out.println("service");

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            
            List<Predicate> orConditions = new ArrayList<>();
//            System.out.println("orConditions1="+orConditions.size());
            
            // 直接在 for 循環內處理 String[] 的轉換和輸出
            for (int i = 0; i < values.length; i++) {
            	if(values[i].isEmpty()) {
//            		System.out.println("null");
            	}else {
            		if ("rentAppAr".equals(key)) {
//                    	predicates.add(criteriaBuilder.equal(root.get("rentAppAr"), values[i]));
                    	orConditions.add(criteriaBuilder.equal(root.get("rentAppAr"), values[i]));
        			}
            		if ("additionalInput".equals(key)) {
            			Predicate rentAppRo = criteriaBuilder.like(root.get("rentAppRo"), "%" + values[i] + "%");
            			Predicate rentAppAdd = criteriaBuilder.like(root.get("rentAppAdd"), "%" + values[i] + "%");
            			Predicate rentPostTitle = criteriaBuilder.like(root.get("rentPostTitle"), "%" + values[i] + "%");
            			predicates.add(criteriaBuilder.or(rentAppRo, rentAppAdd,rentPostTitle));
        			}
            		if ("rentAppCou".equals(key)) {
                    	predicates.add(criteriaBuilder.equal(root.get("rentAppCou"), values[i]));
//                    	System.out.println("rentAppAr="+values[i]);
        			}
            		if ("rentLayout".equals(key)) {
                    	predicates.add(criteriaBuilder.equal(root.get("rentLayout"), Byte.valueOf(values[i])));
        			}
            		if ("rentAppFloor".equals(key)) {
            		    switch (values[i]) {
            		        case "1樓":
            		        	predicates.add(criteriaBuilder.equal(root.get("rentAppFloor"), Integer.valueOf("1")));
            		            break;
            		        case "2-5樓":
            		        	predicates.add(criteriaBuilder.between(root.get("rentAppFloor"), Integer.valueOf("2"), Integer.valueOf("5")));
            		            break;
            		        case "6-11樓":
            		        	predicates.add(criteriaBuilder.between(root.get("rentAppFloor"), Integer.valueOf("6"), Integer.valueOf("11")));
            		            break;
            		        case "12樓以上":
            		        	predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rentAppFloor"), Integer.valueOf("12")));
            		            break;
            		    }
            		}
            		if ("rentAppSize".equals(key)) {
            		    switch (values[i]) {
            		        case "10坪以下":
//            		        	predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rentAppSize"), Double.valueOf("10")));
            		        	orConditions.add(criteriaBuilder.lessThanOrEqualTo(root.get("rentAppSize"), Double.valueOf("10")));
            		        	break;
            		        case "11-20坪":
//            		        	predicates.add(criteriaBuilder.between(root.get("rentAppSize"), Double.valueOf("11"), Double.valueOf("20")));
            		        	orConditions.add(criteriaBuilder.between(root.get("rentAppSize"), Double.valueOf("11"), Double.valueOf("20")));
            		        	break;
            		        case "21-30坪":
//            		        	predicates.add(criteriaBuilder.between(root.get("rentAppSize"), Double.valueOf("21"), Double.valueOf("30")));
            		        	orConditions.add(criteriaBuilder.between(root.get("rentAppSize"), Double.valueOf("21"), Double.valueOf("30")));
            		        	break;
            		        case "30坪以上":
//            		        	predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rentAppSize"), Double.valueOf("30")));
            		        	orConditions.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rentAppSize"), Double.valueOf("30")));
            		        	break;
            		    }
            		}
            		if ("feature".equals(key)) {
            			switch (values[i]) {
            			case "rentBalcony":
            				predicates.add(criteriaBuilder.equal(root.get("rentBalcony"), Byte.parseByte("1")));
            				break;
            			case "rentElev":
            				predicates.add(criteriaBuilder.equal(root.get("rentElev"), Byte.parseByte("1")));
            				break;
            			case "rentParking":
            				predicates.add(criteriaBuilder.equal(root.get("rentParking"), Byte.parseByte("1")));
            				break;
            			case "rentWaterBill":
            				predicates.add(criteriaBuilder.equal(root.get("rentWaterBill"), Byte.parseByte("1")));
            				break;
            			case "rentElectricityBill":
            				predicates.add(criteriaBuilder.equal(root.get("rentElectricityBill"), Byte.parseByte("1")));
            				break;
            			}
            		}
            		if ("equipment".equals(key)) {
            			switch (values[i]) {
            			case "rentRefrigerator":
            				predicates.add(criteriaBuilder.equal(root.get("rentRefrigerator"), Byte.parseByte("1")));
            				break;
            			case "rentAC":
            				predicates.add(criteriaBuilder.equal(root.get("rentAC"), Byte.parseByte("1")));
            				break;
            			case "rentTV":
            				predicates.add(criteriaBuilder.equal(root.get("rentTV"), Byte.parseByte("1")));
            				break;
            			case "rentWashMachine":
            				predicates.add(criteriaBuilder.equal(root.get("rentWashMachine"), Byte.parseByte("1")));
            				break;
            			case "rentHeater":
            				predicates.add(criteriaBuilder.equal(root.get("rentHeater"), Byte.parseByte("1")));
            				break;
            			case "rentBed":
            				predicates.add(criteriaBuilder.equal(root.get("rentBed"), Byte.parseByte("1")));
            				break;
            			case "rentWardrobe":
            				predicates.add(criteriaBuilder.equal(root.get("rentWardrobe"), Byte.parseByte("1")));
            				break;
            			case "rentInternet":
            				predicates.add(criteriaBuilder.equal(root.get("rentInternet"), Byte.parseByte("1")));
            				break;
            			case "rentCableTV":
            				predicates.add(criteriaBuilder.equal(root.get("rentCableTV"), Byte.parseByte("1")));
            				break;
            			case "rentSofa":
            				predicates.add(criteriaBuilder.equal(root.get("rentSofa"), Byte.parseByte("1")));
            				break;
            			}
            		}
            		if ("rentRent".equals(key)) {
            			switch (values[i]) {
            			case "5000元以下":
//            				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rentRent"), Integer.valueOf("5000")));
            				orConditions.add(criteriaBuilder.lessThanOrEqualTo(root.get("rentRent"), Integer.valueOf("5000")));
            				break;
            			case "5000-10000元":
//            				predicates.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("5000"), Integer.valueOf("10000")));
            				orConditions.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("5000"), Integer.valueOf("10000")));
            				break;
            			case "10000-20000元":
//            				predicates.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("10000"), Integer.valueOf("20000")));
            				orConditions.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("10000"), Integer.valueOf("20000")));
            				break;
            			case "20000-30000元":
//            				predicates.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("20000"), Integer.valueOf("30000")));
            				orConditions.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("20000"), Integer.valueOf("30000")));
            				break;
            			case "30000-40000元":
//            				predicates.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("30000"), Integer.valueOf("40000")));
            				orConditions.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf("30000"), Integer.valueOf("40000")));
            				break;
            			case "40000元以上":
//            				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rentRent"), Integer.valueOf("40000")));
            				orConditions.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rentRent"), Integer.valueOf("40000")));
            				break;
            			default:
            				rentRentBetween.add(values[i]);
            	            break;
            			}
            		}
            	}
                
            }
//            System.out.println("orConditions2="+orConditions.size());
            if(orConditions.size()!=0) {
            	
            	predicates.add(criteriaBuilder.or(orConditions.toArray(new Predicate[0])));
            }
        }
        if(rentRentBetween.size()!=0) {
        	predicates.add(criteriaBuilder.between(root.get("rentRent"), Integer.valueOf(rentRentBetween.get(0)), Integer.valueOf(rentRentBetween.get(1))));
        }
        
        predicates.add(criteriaBuilder.equal(root.get("rentSt"), Byte.parseByte("1")));
//        System.out.println("predicates2="+predicates.size());
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("rentRent")));
        List<Rent> query = entityManager.createQuery(criteriaQuery).getResultList();
        
//        System.out.println("rentRentBetween="+rentRentBetween.size());
        System.out.println("query="+query.size());
     // 將所有條件組合成一個 AND 條件
//        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        criteriaQuery.where(finalPredicate);

        // 執行查詢
//        return entityManager.createQuery(criteriaQuery).getResultList();
//        for (Rent rent : query) {
//            System.out.println(rent); // 假设Rent类有适当的toString方法
//        }
		
		return query;
	}


}
