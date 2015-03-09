require 'minitest/autorun'

require_relative './keppy.rb'

class StringAutomaTest < MiniTest::Unit::TestCase
  def test_one_step
    set = [1, 2, 3, 4, 5, 6]
    expected = [6, 1, 2, 3, 4, 5]
    n = 1
    assert_equal(expected, StringAutoma.solve(set,n))
  end

  def test_odd_split
    set = [1, 2, 3, 4, 5, 6, 1, 2, 3]
    expected = [1, 2, 3, 1, 2, 3, 4, 5, 6]
    n = 3
    assert_equal(expected, StringAutoma.solve(set,n))
  end

  def test_over_step
    set = [1, 2, 3]
    expected = [3, 1, 2]
    n = 4
    assert_equal(expected, StringAutoma.solve(set,n))
  end
end
