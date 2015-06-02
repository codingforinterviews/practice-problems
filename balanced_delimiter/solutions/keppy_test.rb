
require 'minitest/autorun'

require_relative './keppy.rb'

class ParseRulesTest < MiniTest::Unit::TestCase
  def setup
    @parse_tree = [
      {:state => "[", :possible_states => ["{", "(", "["], :close_this_state => "]"},
      {:state => "{", :possible_states => ["{", "(", "["], :close_this_state => "}"},
      {:state => "(", :possible_states => ["{", "(", "["], :close_this_state => ")"}
    ]
  end

  def test_parse_rules_with_existing_delim
    # This is a stack that has seen an opening paren
    stack = ["("]
    parse_rules = ParseRules.new(@parse_tree)
    parse_rules.method(:"(").call(")", stack)
    assert_equal([], stack)
  end

  def test_parse_rules_with_wrong_match
    stack = ["{"]
    parse_rules = ParseRules.new(@parse_tree)
    result = parse_rules.method(:"{").call(")", stack)
    assert_equal(false, result)
  end

  def test_parse_rules_wrong_match_with_multiple_delims
    stack = ["(", "{", "["]
    parse_rules = ParseRules.new(@parse_tree)
    result = parse_rules.method(:"[").call(")", stack)
    assert_equal(false, result)
  end

  def test_parse_rules_correct_match_multiple_delims
    stack = ["(", "{", "["]
    expected_stack = ["(", "{"]
    parse_rules = ParseRules.new(@parse_tree)
    result = parse_rules.method(:"[").call("]", stack)
    assert_equal(expected_stack, stack)
  end

end

class StringParserTest < MiniTest::Unit::TestCase
  def test_closing_delim
    parser = StringParser.new
    assert_equal(false, parser.solve("]"))
  end

  def test_open_delim
    parser = StringParser.new
    assert_equal(false, parser.solve("["))
  end

  def test_complicated_correct
    parser = StringParser.new
    chars = "()[]{}([{}])([]{})"
    assert_equal(true, parser.solve(chars))
  end

  def test_complicated_incorrect
    parser = StringParser.new
    chars = "([)]([][])([})"
    assert_equal(false, parser.solve(chars))
  end
end
