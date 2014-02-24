@delims = { '[' => ']', '{' => '}', '(' => ')' }

# Convenience function for picking a random value out of a hash.
def hashrand(h)
	h[h.keys.shuffle[0]]
end

# This generates a valid delimiter string using a Markov chain-like process.
def generate_pairs(max_pairs)
	pairs = 0
	opens = Array.new
	result = String.new

	while pairs < max_pairs
		if rand() < 0.7 || opens.empty?
			opens.push(hashrand(@delims.invert))
			result += opens.last
			pairs += 1
		else
			result += @delims[opens.pop]
		end
	end
	
	# Close any open delimiters
	while closer = @delims[opens.pop]
		result += closer
	end

	return result
end

# This randomly invalidates a delimiter string by introducing one of the
# following errors at a random position:
# 	- Delete a delimiter
# 	- Add a delimiter
# 	- Change a delimiter to a different character
#
# Alternatively, it will delete the last delimiter, so that the otherwise
# unlikely failure state of an unclosed delimiter at the end of the string will
# occur with reasonable frequency.
def make_invalid(str)
	err = rand()
	index = rand(str.length - 2)

	if err < 0.25
		# "Delete"
		return str[0..index] + str[(index + 2)..(str.length - 1)]
	elsif err < 0.50
		# "Add"
		newchar = (@delims.flatten - [str[index]]).shuffle[0]
		return str[0..index] + newchar + str[(index + 1)..(str.length - 1)]
	elsif err < 0.75
		# "Unclosed"
		return str[0..(str.length - 2)]
	else
		# "Change"
		newchar = (@delims.flatten - [str[index]]).shuffle[0]
		return str[0..index] + newchar + str[(index + 2)..(str.length - 1)]
	end
end

# These are my selected inputs for the problem; they are ordered by increasing
# difficulty of n. For each of these, one valid and one invalid string will be
# created for that number of pairs.
selected = [3, 5, 10, 100, 1000, 10000]

@fcount = -1
selected.each_index { |i|
	fmode = File::WRONLY | File::CREAT
	path = "../tests/"

	@fcount += 1
	input = File.new("#{path}input#{sprintf("%02d", @fcount)}.txt", fmode)
	output = File.new("#{path}output#{sprintf("%02d", @fcount)}.txt", fmode)

	input_str = generate_pairs(selected[i])
	input.write(input_str)
	output.write("True")

	@fcount += 1
	input = File.new("#{path}input#{sprintf("%02d", @fcount)}.txt", fmode)
	output = File.new("#{path}output#{sprintf("%02d", @fcount)}.txt", fmode)
	input.write(make_invalid(input_str))
	output.write("False")
}
