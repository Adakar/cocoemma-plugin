package hudson.plugins.cocoemma.portlet.utils;

import hudson.model.FreeStyleProject;
import hudson.model.Job;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.jvnet.hudson.test.HudsonTestCase;

/**
 * Test {@link hudson.plugins.cocoemma.portlet.utils.Utils}
 * through HudsonTestCase extension.
 *
 * @author Mauro Durante Junior &lt;Mauro.Durantejunior@sonyericsson.com&gt;
 */
public class UtilsHudsonTest extends HudsonTestCase {

  /**
   * Tests {@link hudson.plugins.cocoemma.portlet.utils.Utils#getLastDate(java.util.List) }.
   * @throws Exception on any exception occurrence.
   */
  public void testGetLastDate() throws Exception {

    FreeStyleProject prj = createFreeStyleProject("prj1");
    prj.scheduleBuild2(0).get();
    FreeStyleProject prj2 = createFreeStyleProject("prj2");
    prj2.scheduleBuild2(0).get();

    List<Job> jobs = new ArrayList<Job>();
    jobs.add(prj);
    jobs.add(prj2);

    LocalDate lastDate = Utils.getLastDate(jobs);
    assertNotNull(lastDate);
  }

  /**
   * Tests {@link hudson.plugins.cocoemma.portlet.utils.Utils#roundFLoat(int scale, RoundingMode roundingMode, float value) }.
   */
  public void testRoundFloat() {
    int scale = 1;
    final float value = 9.987f;
    final float roundedAs = 10f;

    assertEquals(roundedAs, Utils.roundFLoat(scale, RoundingMode.HALF_EVEN, value));
  }
}
