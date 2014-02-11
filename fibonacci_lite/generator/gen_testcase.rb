# Naive implementation. We'll choose correctness over speed here.
def fib(n)
	case n
	when 0
		0
	when 1
		1
	else
		fib(n - 1) + fib(n - 2)
	end
end

# These are my selected inputs for the problem; they are ordered by increasing
# difficulty of n, and includes the "edge case" of n = 47, the largest value in
# the Fibonacci sequence that will fit in a 32-bit integer. Also, just for fun,
# all of the inputs are prime.
selected = [1, 7, 13, 19, 23, 29, 31, 37, 41, 47]

selected.each_index { |i|
	fmode = File::WRONLY | File::CREAT
	path = "fib-cases/"
	input = File.new("#{path}input/input#{sprintf("%02d", i)}.txt", fmode)
	output = File.new("#{path}output/output#{sprintf("%02d", i)}.txt", fmode)

	input.write(selected[i].to_s)
	output.write(fib(selected[i]).to_s)
}
