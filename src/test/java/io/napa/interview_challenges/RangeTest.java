package test.java.io.napa.interview_challenges;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

public class RangeTest {

  @Test
  public void should_create_range() {
    Range range = Range.of(5, 50);
    assertThat(range.lowerbound()).isEqualTo(5);
    assertThat(range.upperbound()).isEqualTo(50);
  }

  @Test
  public void should_throw_error_when_create_with_lowerbound_bigger_than_upperbound() {
    try {
      Range.of(500, 1);
      fail("Should not allow creating a invalid Range");
    } catch(IllegalArgumentException e) {
      // pass
    }
  }

  @Test
  public void closed_range_should_contain_both_bounds_and_all_elements_in_between() {
    Range closedRange = Range.of(5, 50);

    assertThat(closedRange.contains(Integer.MIN_VALUE)).isEqualTo( false);
    assertThat(closedRange.contains(4)).isEqualTo( false);

    assertThat(closedRange.contains(5)).isEqualTo( true);

    assertThat(closedRange.contains(42)).isEqualTo( true);

    assertThat(closedRange.contains(50)).isEqualTo( true);

    assertThat(closedRange.contains(10000)).isEqualTo( false);
    assertThat(closedRange.contains(Integer.MAX_VALUE)).isEqualTo( false);
  }

  @Test
  public void open_range_excludes_both_bounds(){
    Range openRange = Range.open(5, 50);

    assertThat(openRange.contains(Integer.MIN_VALUE)).isEqualTo( false);
    assertThat(openRange.contains(4)).isEqualTo( false);

    assertThat(openRange.contains(5)).isEqualTo( false);

    assertThat(openRange.contains(42)).isEqualTo( true);

    assertThat(openRange.contains(50)).isEqualTo( false);

    assertThat(openRange.contains(10000)).isEqualTo( false);
    assertThat(openRange.contains(Integer.MAX_VALUE)).isEqualTo( false);
  }

  @Test
  public void open_closed_excludes_lowerbound_but_includes_upperbound(){
    Range openClosedRange = Range.openClosed(5, 50);

    assertThat(openClosedRange.contains(Integer.MIN_VALUE)).isEqualTo( false);
    assertThat(openClosedRange.contains(4)).isEqualTo( false);

    assertThat(openClosedRange.contains(5)).isEqualTo( false);

    assertThat(openClosedRange.contains(42)).isEqualTo( true);

    assertThat(openClosedRange.contains(50)).isEqualTo( true);

    assertThat(openClosedRange.contains(10000)).isEqualTo( false);
    assertThat(openClosedRange.contains(Integer.MAX_VALUE)).isEqualTo( false);
  }

  @Test
  public void closed_open_includes_lowerbound_but_excludes_upperbound(){
    Range openClosedRange = Range.closedOpen(5, 50);

    assertThat(openClosedRange.contains(Integer.MIN_VALUE)).isEqualTo( false);
    assertThat(openClosedRange.contains(4)).isEqualTo( false);

    assertThat(openClosedRange.contains(5)).isEqualTo( true);

    assertThat(openClosedRange.contains(42)).isEqualTo( true);

    assertThat(openClosedRange.contains(50)).isEqualTo( false);

    assertThat(openClosedRange.contains(10000)).isEqualTo( false);
    assertThat(openClosedRange.contains(Integer.MAX_VALUE)).isEqualTo( false);
  }

  @Test
  public void range_should_be_state_independent() {
    Range range1 = Range.of(5, 10);
    Range range2 = Range.of(11, 20);

    assertThat(range1.contains(10)).isEqualTo( true);
    assertThat(range2.contains(10)).isEqualTo( false);
  }

  @Test
  public void should_create_range_generic(){
    RangeGeneric rangeGenericStr = RangeGeneric.of("abc","opq");
    RangeGeneric rangeGenericInt = RangeGeneric.of(2,10);
    RangeGeneric rangeGenericDouble = RangeGeneric.of(3.5,5.5);
    RangeGeneric rangeGenericDate = RangeGeneric.of(LocalDate.of(2020, Month.JANUARY,1),LocalDate.of(2022,Month.DECEMBER,31));
    RangeGeneric rangeGenericDecimal = RangeGeneric.of(BigDecimal.valueOf(3.42423234),BigDecimal.valueOf(5.4234234234));

    assertThat(rangeGenericStr.contains("def")).isEqualTo(true);
    assertThat(rangeGenericStr.contains("xyz")).isEqualTo(false);

    assertThat(rangeGenericInt.contains(2)).isEqualTo(true);
    assertThat(rangeGenericInt.contains(1)).isEqualTo(false);

    assertThat(rangeGenericDouble.contains(4.5)).isEqualTo(true);
    assertThat(rangeGenericDouble.contains(3.0)).isEqualTo(false);

    assertThat(rangeGenericDate.contains(LocalDate.of(2021,Month.DECEMBER,1))).isEqualTo(true);
    assertThat(rangeGenericDate.contains(LocalDate.of(2023,Month.JANUARY,1))).isEqualTo(false);

    assertThat(rangeGenericDecimal.contains(BigDecimal.valueOf(4.1232132))).isEqualTo(true);
    assertThat(rangeGenericDecimal.contains(BigDecimal.valueOf(3.12444333))).isEqualTo(false);
  }
}
