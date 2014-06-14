import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class ServiceLaneTest {

    @Test
    public void testServiceLane()
    {
        int[] N = new int[]{2,3,1,2,3,2,3,3};

        Assert.assertEquals(1, ServiceLane.findVehicleWidth(N, 0, 2));
        Assert.assertEquals(2, ServiceLane.findVehicleWidth(N, 0, 1));
        Assert.assertEquals(3, ServiceLane.findVehicleWidth(N, 1, 1));
        Assert.assertEquals(1, ServiceLane.findVehicleWidth(N, 1, 2));
        Assert.assertEquals(1, ServiceLane.findVehicleWidth(N, 1, 5));
        Assert.assertEquals(3, ServiceLane.findVehicleWidth(N, 6, 7));
    }

}
