package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport implements Serializable {

    private String country;
    private String name;
    private int amountRunaways;
    private int planesCapacity;
    private List<Plane> planes = new ArrayList<>();
}