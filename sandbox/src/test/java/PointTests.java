import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.sandbox.Point;

/**
 * Created by Homosapiens on 30.04.2016.
 */
public class PointTests {

  @Test

  public void testDistance(){
    Point p = new Point(1,2,4,6);
    Assert.assertEquals(p.distance(),5.0);

  }
}
