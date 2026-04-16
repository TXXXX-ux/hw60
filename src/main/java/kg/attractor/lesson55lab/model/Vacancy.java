package kg.attractor.lesson55lab.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vacancies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double salary;
}
