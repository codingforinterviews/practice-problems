#!/bin/usr/env python
import unittest
from rotate import rotate as r


class RotateTestCase(unittest.TestCase):
    def setUp(self):
        test = [1, 2, 3]
        self.test_cases = (
            (test, 3),
            (test, 0),
            (test, 4),
            (test, 5),
            (test, 1)
        )
        self.test_answers = (
            test, test,
            [3, 1, 2], [2, 3, 1],
            [3, 1, 2]
        )

    def tearDown(self):
        del self.test_cases
        del self.test_answers

    def test_rotate_function(self):
        for idx, test_case in enumerate(self.test_cases):
            self.assertEqual(r(*test_case), self.test_answers[idx])

if __name__ == '__main__':
    unittest.main()
