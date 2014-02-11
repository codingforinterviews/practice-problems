# Parse tree into lame adjacency hash thing
@tree = Hash.new
@root = 0
ARGF.each_line {|line|
	values = line.split(/\s+/)

	if ARGF.lineno == 1
		@root = values[0].to_i
	end

	@tree[values[0].to_i] = [values[1].to_i, values[2].to_i]
}

def find_val(side, depth)
	find_val_r(side, depth, @root, 0)
end

def find_val_r(side, depth, node, level)
	if level == depth && node != -1
		puts node
		true
	elsif @tree[node].nil? || node == -1
		false
	else
		find_val_r(side, depth, @tree[node][side], level + 1) ||
		find_val_r(side, depth, @tree[node][side ^ 1], level + 1)
	end
end

side = 0
depth = 0

while find_val(side, depth)
	side ^= 1
	depth += 1
end
