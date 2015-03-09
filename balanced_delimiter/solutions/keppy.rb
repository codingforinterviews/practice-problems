class ParseRules
  # Rather than hardcoding each possible case into the StringParser,
  # we abstract out the parsing rules into a class with one method for each
  # allowed state. Then we can match on arbitrary parse tree values.
  # The only restrictions to our language is that we assume each significant character is a delimiter,
  # and that there are zero or more possible states 'in between' delimiters.
  # There will never be a closing delimiter on the stack.

  def initialize(tree)
  # These rules dictate what can come next in the state machine
    tree.each do |leaf|
      self.class.send(:define_method, leaf[:state].to_sym) do |next_state, stack|
        if leaf[:possible_states].include?(next_state)
          stack.push(next_state)
        elsif leaf[:close_this_state] == next_state
          stack.pop()
        else
          return false
        end
      end
    end
  end

end
        

class StringParser
  def initialize
    @delimiters = "{[()]}"
    @opening_delimiters = "{(["
    @closing_delimiters = "}])"
    @stack = []
    @parse_tree = [
      {:state => "[", :possible_states => ["{", "(", "["], :close_this_state => "]"},
      {:state => "{", :possible_states => ["{", "(", "["], :close_this_state => "}"},
      {:state => "(", :possible_states => ["{", "(", "["], :close_this_state => ")"}
    ]
    @parser = ParseRules.new(@parse_tree)
  end

  def solve(character_set)
    return false if character_set.length < 2
    character_set.chars.each do |char|
      if @stack.empty? && @closing_delimiters.include?(char)
        return false
      elsif @stack.empty? && @opening_delimiters.include?(char)
        @stack.push(char)
      elsif @delimiters.include?(char) 
        @parser.method(@stack[-1].to_sym).call(char, @stack)
      end
    end
    @stack.empty? ? true : false
  end
end
