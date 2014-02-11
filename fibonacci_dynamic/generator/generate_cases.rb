@memos = Hash.new
def fib(n)
	if @memos[n]
		return @memos[n]
	else
		i = 0
		k = 0
		last_1 = 1
		last_2 = 0
		while i < n
			last_2 = last_1
			last_1 = k
			k = last_1 + last_2
			i += 1
		end
		
		@memos[n] = k
		return k
	end
end

# These are my selected inputs for the problem; they are ordered by increasing
# difficulty of n, and includes the "edge case" of n = 47, the largest value in
# the Fibonacci sequence that will fit in a 32-bit integer.
selected = [
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	[40, 2],
	Array.new(1000) {|i| i = rand(1..99)},
	Array.new(2000) {|i| i = rand(1..99)},
	Array.new(3000) {|i| i = rand(1..99)},
	Array.new(4000) {|i| i = rand(1..99)},
	Array.new(5000) {|i| i = rand(1..99)}
]

selected.each_index { |i|
	fmode = File::WRONLY | File::CREAT
	path = "fib-cases/"
	input = File.new("#{path}input/input#{sprintf("%02d", i)}.txt", fmode)
	output = File.new("#{path}output/output#{sprintf("%02d", i)}.txt", fmode)

	input.write(selected[i].join("\n"))
	selected[i].each {|n| output.write(fib(n).to_s + "\n")}
	puts "#{i + 1}/#{selected.length}"
}
