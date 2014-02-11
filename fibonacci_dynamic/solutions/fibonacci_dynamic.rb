# Initialize an empty hash to memoize values into
@memos = { 0 => 0, 1 => 1 }

def fib(n)
    # Check if we already have a result for this value of n
    if @memos[n]
        return @memos[n]
    else
        # Otherwise, compute the result iteratively
        i = @memos.keys.max || 0
        k = @memos[@memos.keys.max] || 0
        last_1 = n < 2 ? 1 : @memos[i - 1]

        while i < n
            last_2 = last_1
            last_1 = k
            k = last_1 + last_2
            # Memoize the result for later
            i += 1
            @memos[i] = k
        end
        
        return k
    end
end

ARGF.each_line {|n|
    puts fib(n.to_i)
}
