#!/usr/bin/env node

// Solve the "Coin Change" problem using a bottom-up dynamic programming
// approach. The time complexity is O(n * coins.length) since we have a nested
// loop. The storage complexity is the same, as we store a matrix.
//
// * `coins` is an array of the coin values, eg. [ 1, 2, 3 ]. We assume it
//   to be non-empty.
// * `n` is the amount, eg. 4 cents.
//
// The top-down solution is also possible (memoization), but can causes
// stack-overflows for large inputs.
//
function findPermutations(coins, n) {

    // The 2-dimension buffer will contain answers to this question:
    // "how much permutations is there for an amount of `i` cents, and `j`
    // remaining coins?" eg. `buffer[10][2]` will tell us how many permutations
    // there are when giving back 10 cents using only the first two coin types
    // [ 1, 2 ].
    var buffer = new Array(n + 1);
    for (var i = 0; i <= n; ++i)
        buffer[i] = new Array(coins.length + 1);

    // For all the cases where we need to give back 0 cents, there's exactly
    // 1 permutation: the empty set. Note that buffer[0][0] won't ever be
    // needed.
    for (var j = 1; j <= coins.length; ++j)
        buffer[0][j] = 1;

    // We process each case: 1 cent, 2 cent, etc. up to `n` cents, included.
    for (i = 1; i <= n; ++i) {

        // No more coins? No permutation is possible to attain `i` cents.
        buffer[i][0] = 0;

        // Now we consider the cases when we have J coin types available.
        for (j = 1; j <= coins.length; ++j) {

            // First, we take into account all the known permutations possible
            // _without_ using the J-th coin (actually computed at the previous
            // loop step).
            var value = buffer[i][j - 1];

            // Then, we add all the permutations possible by consuming the J-th
            // coin itself, if we can.
            if (coins[j - 1] <= i)
                value += buffer[i - coins[j - 1]][j];

            // We now know the answer for this specific case.
            buffer[i][j] = value;
        }
    }

    // Return the bottom-right answer, the one we were looking for in the
    // first place.
    return buffer[n][coins.length];
}

// The boring stuff: parsing and printing.
//
function processData(input) {
    var lines = input.split('\n');
    var coins = lines[0].split(',').map(function (s) {return +s;});
    var n = +lines[1];
    var res = findPermutations(coins, n);
    console.log(res);
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
