package kpi.studying.coursework.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kpi.studying.coursework.entity.CostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostsService {

    @Autowired
    private MongoTemplate costsMongoTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    public void uploadCost(CostEntity entity) {
        costsMongoTemplate.insert(entity);
    }
    public void uploadAllCost(List<CostEntity> entityList) {
        costsMongoTemplate.insert(entityList);
    }

    public void removeCost(CostEntity entity) {
        Query removeQuery = new Query();
        removeQuery.addCriteria(Criteria.where("name").is(entity.getName()));
        costsMongoTemplate.remove(removeQuery, CostEntity.class);
    }

    public void saveNewCostFromJson(String json) {
        CostEntity requestEntity = null;
        try {
            requestEntity = mapper.readValue(json, CostEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        uploadCost(requestEntity);
    }

    public void removeCostByName(String name) {
        Query removeQuery = new Query();
        removeQuery.addCriteria(Criteria.where("name").is(name));
        costsMongoTemplate.remove(removeQuery, CostEntity.class);
    }

    public List<CostEntity> findAll() {
        return costsMongoTemplate.findAll(CostEntity.class);
    }
}
