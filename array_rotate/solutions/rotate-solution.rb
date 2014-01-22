def rotate_jump(array, n)
  return array if n == 0 || array.length == 0

  result = []

  (0...array.length).each do |i|
    result[(i + n % array.length) % array.length] = array[i]
  end

  result
end

def rotate_step(array, n)
  return array if n == 0 || array.length == 0

  n.times do
    array = array[0...array.length - 1].unshift(array[-1])
  end

  array
end

require 'test/unit'
class RotateTest < Test::Unit::TestCase

  def test_step()
    rotate_check_helper(method(:rotate_step))
  end

  def test_jump()
    rotate_check_helper(method(:rotate_jump))
  end

  def rotate_check_helper(m)
    assert_equal([], m.call([],1))
    assert_equal([1], m.call([1],1))
    assert_equal([2, 1], m.call([1, 2],1))
    assert_equal([1,2,3], m.call([1, 2, 3],3))
    assert_equal([3, 4, 5, 6, 7, 8, 9, 10, 1, 2], m.call([1,2,3,4,5,6,7,8,9,10],8))
    assert_equal([9,10,1,2,3,4,5,6,7,8], m.call([1,2,3,4,5,6,7,8,9,10],2))
  end
end
