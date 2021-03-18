package com.paulevers.spotsgateway.entities;

import com.paulevers.spotsgateway.classes.Coordinates;
import lombok.Data;

@Data
public class Spot {
    String id;
    String name;
    Coordinates coordinates;
    String category;
}
