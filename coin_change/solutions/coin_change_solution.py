import cPickle as pickle
import sys


def memoize(func):
    cache = {}

    def wrapper(*args, **kwargs):
        key = pickle.dumps(args) + pickle.dumps(kwargs)
        if key not in cache:
            cache[key] = func(*args, **kwargs)
        return cache[key]
    return wrapper


@memoize
def solve(coins, amount):
    if len(coins) == 0:
        return 0
    if len(coins) == 1:
        return 1 if amount % coins[0] == 0 else 0
    ways = 0
    current_coin, rest_of_coins = coins[0], coins[1:]
    i = 0
    while amount - i * current_coin >= 0:
        ways += solve(rest_of_coins, amount - i * current_coin)
        i += 1
    return ways


def main():
    coins = sorted(map(int, sys.stdin.readline().strip().split(",")),
                   reverse=True)
    amount = int(sys.stdin.readline().strip())
    ways = solve(coins, amount)
    print(ways)

if __name__ == "__main__":
    main()
