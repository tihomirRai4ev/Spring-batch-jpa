package com.traychev.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.traychev.beans.BorderCrossingsData;

/**
 *
 * @author Tihomir
 *
 */
@Service
public class BorderDataService implements IBorderDataService {

	@Autowired
	BorderDataRepository bRepository;

	@Autowired
	CrossingsRepository cRepository;

	public BorderDataService() {
	}

	@Override
	public List<BorderData> findAll() {
		List<BorderData> data = (List<BorderData>) bRepository.findAll();
		return data;
	}

	@Override
	public BorderData save(BorderData entity) {
		return bRepository.save(entity);
	}

	@Override
	public List<BorderCrossingsData> fetchBorderCrossingData() {
		List<BorderCrossingsData> result = new LinkedList<BorderCrossingsData>();
		Map<BorderData, List<Crossings>> helper = new HashMap<BorderData, List<Crossings>>();
		List<Crossings> cEntities = cRepository.findAll();

		for (Crossings crs : cEntities) {
			BorderData data = crs.getBorderData();
			if (helper.containsKey(data)) {
				helper.get(data).add(crs);
			} else {
				List<Crossings> cList = new LinkedList<Crossings>();
				cList.add(crs);
				helper.put(crs.getBorderData(), cList);
			}
		}

		for (BorderData entity : helper.keySet()) {
			BorderCrossingsData bean = new BorderCrossingsData();
			bean.setFirstName(entity.getFirstName());
			bean.setLastName(entity.getLastName());
			bean.setNationality(entity.getNationality());
			bean.setPassportId(entity.getPassportId());
			List<Crossings> crsList = helper.get(entity);
			com.traychev.beans.Crossings[] crossingsBeans = new com.traychev.beans.Crossings[crsList.size()];
			int i = 0;
			for (Crossings crs : crsList) {
				com.traychev.beans.Crossings cBean = new com.traychev.beans.Crossings();
				cBean.setEnter(Boolean.valueOf(crs.getEnter()));
				cBean.setLocation(crs.getLocation());
				cBean.setTime(crs.getTime());
				crossingsBeans[i++] = cBean;
			}
			bean.setCrossings(crossingsBeans);
			result.add(bean);
		}

		return result;
	}

	@Override
	public List<BorderCrossingsData> fetchBorderCrossingData(String timestamp) {
		List<BorderCrossingsData> allEntitiesfetched = fetchBorderCrossingData();
		List<BorderCrossingsData> result = new LinkedList<BorderCrossingsData>();
		for (int i = 0; i < allEntitiesfetched.size(); i++) {
			List<com.traychev.beans.Crossings> crossingsByTimestamp = new LinkedList<com.traychev.beans.Crossings>();
			com.traychev.beans.Crossings[] crs = allEntitiesfetched.get(i).getCrossings();
			for (com.traychev.beans.Crossings cr : crs) {
				if (cr.getTime().equals(timestamp)) {
					crossingsByTimestamp.add(cr);
				}
			}
			allEntitiesfetched.get(i).setCrossingsFromList(crossingsByTimestamp);
			if (!crossingsByTimestamp.isEmpty()) {
				result.add(allEntitiesfetched.get(i));
			}
		}
		return result;
	}

	/**
	 * TODO:// Not effective.
	 *
	 * @see com.traychev.service.BorderDataService.findByPassportId
	 * @param passportId
	 * @return
	 */
	public List<com.traychev.beans.Crossings> fetchCrossingsByPassportID(String passportId) {
		List<BorderCrossingsData> allEntitiesfetched = fetchBorderCrossingData();
		List<com.traychev.beans.Crossings> result = new LinkedList<com.traychev.beans.Crossings>();
		for (BorderCrossingsData bean : allEntitiesfetched) {
			if (String.valueOf(bean.getPassportId()).equals(passportId)) {
				result.addAll(Arrays.asList(bean.getCrossings()));
			}
		}
		return result;
	}

	public Optional<BorderData> findByPassportId(Long passportId) {
		BorderData exData = new BorderData();
		exData.setPassportId(passportId);
		Example<BorderData> example = Example.of(exData);
		return bRepository.findOne(example);
	}

	@Override
	public Optional<BorderData> findOne(Example<BorderData> example) {
		return bRepository.findOne(example);
	}

}