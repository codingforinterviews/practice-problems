# Enter your code here. Read input from STDIN. Print output to STDOUT
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

puts fib(ARGF.gets.to_i)
