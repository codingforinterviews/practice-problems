class StringAutoma

  def self.solve(set, n)
    # set is an array, n is an integer.
    n.times do
      set.unshift(set.pop())
    end
    return set
  end

end
