package info;

import com.github.robocup_atan.atan.model.enums.Flag;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raghavnarula on 06/11/2015.
 */
public class SeeFlagInfoTest {

    @Test
    public void testLeftCenter() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,0)));
    }

    @Test
    public void testLeftOwn10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_10,
                0, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,-10)));
    }

    @Test
    public void testLeftOwn20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,-20)));
    }

    @Test
    public void leftLeftOwn30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,-30)));
    }

    @Test
    public void leftLeftOwn40() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_40,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,-40)));
    }

    @Test
    public void testLeftOwn50() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_50,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,-50)));
    }

    @Test
    public void testLeftOther10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,10)));
    }

    @Test
    public void testLeftOther20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,20)));
    }

    @Test
    public void testLeftOther30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,30)));
    }

    @Test
    public void testLeftOther40() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_40,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,40)));
    }

    @Test
    public void testLeftOther50() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_50,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-39,50)));
    }

    @Test
    public void testRightCenter() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,0)));
    }

    @Test
    public void testRightOwn10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,-10)));
    }

    @Test
    public void testRightOwn20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,-20)));
    }

    @Test
    public void testRightOwn30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,-30)));
    }

    @Test
    public void testRightOwn40() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_40,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,-40)));
    }

    @Test
    public void testRightOwn50() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_50,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,-50)));
    }

    @Test
    public void testRightOther10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,10)));
    }

    @Test
    public void testRightOther20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,20)));
    }

    @Test
    public void testRightOther30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,30)));
    }

    @Test
    public void testRightOther40() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_40,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,40)));
    }

    @Test
    public void testRightOther50() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_50,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(39,50)));
    }

    @Test
    public void testOwnCenter() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(0,-57.5)));
    }

    @Test
    public void testOwnLeft10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.LEFT_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-10,-57.5)));
    }

    @Test
    public void testOwnLeft20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.LEFT_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-20,-57.5)));
    }

    @Test
    public void testOwnLeft30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.LEFT_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-30,-57.5)));
    }

    @Test
    public void testOwnRight10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.RIGHT_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(10,-57.5)));
    }

    @Test
    public void testOwnRight20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.RIGHT_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(20,-57.5)));
    }

    @Test
    public void testOwnRight30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.RIGHT_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(30,-57.5)));
    }

    @Test
    public void testOtherCenter() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(0,57.5)));
    }

    @Test
    public void testOtherLeft10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.LEFT_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-10,57.5)));
    }

    @Test
    public void testOtherLeft20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.LEFT_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-20,57.5)));
    }

    @Test
    public void testOTherLeft30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.LEFT_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(-30,57.5)));
    }

    @Test
    public void testOtherRight10() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_10,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(10,57.5)));
    }

    @Test
    public void testOtherRight20() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_20,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(20,57.5)));
    }

    @Test
    public void testOtherRight30() throws Exception {
        //given
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_30,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0);
        //when
        Vector2D loc = f.getBoundryFlagLocation();
        //then
        Assert.assertThat("computed location matched expected", loc, IsEqual.equalTo(new Vector2D(30,57.5)));
    }
    @Test
    public void testIsBoundryFlag() throws Exception {

    }
}