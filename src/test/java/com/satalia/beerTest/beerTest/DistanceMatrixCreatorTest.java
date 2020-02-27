package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.mainTask.DistanceMatrixCreator;
import com.satalia.beerTest.beerTest.services.DistanceService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DistanceMatrixCreatorTest {
    @Mock
    private DistanceService distanceService;

    @InjectMocks
    private DistanceMatrixCreator distanceMatrixCreator;

    @Test
    public void calculateDistanceUsingMatrixTest(){
        List<GeoLocation>distances = createListOfDistances();
        Mockito.when(distanceService.calculateDistance(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(1D)
                .thenReturn(2D);

        double[][] matrix = distanceMatrixCreator.calculateDistanceUsingMatrix(distances);

        Assert.assertEquals(0D, matrix[0][0], 0d);
        Assert.assertEquals(1D, matrix[0][1], 0d);
        Assert.assertEquals(3D, matrix[1][0], 0d);
        Assert.assertEquals(0D, matrix[1][1], 0d);

    }

    private List<GeoLocation> createListOfDistances() {
        List<GeoLocation> distances = new ArrayList<>();
        distances.add(new GeoLocation(1, 10d));
        distances.add(new GeoLocation(2, 20d));
        return distances;
    }
}
