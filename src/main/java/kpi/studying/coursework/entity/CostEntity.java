package kpi.studying.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostEntity {

    @Id
    private String id;
    private String type;
    private String name;
    private Long amount;

}
