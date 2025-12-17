package org.xworkz.theaterapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheaterDTO {

    private int theaterId;
    private String theaterName;
    private String location;
    private int screens;

    @Override
    public String toString() {
        return "TheaterDTO{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", location='" + location + '\'' +
                ", screens=" + screens +
                '}';
    }
}
