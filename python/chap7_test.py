#!/usr/bin/env python
from chap7 import ChapterSeven
from ListNode import ListNode
import unittest

"""Tests of Chapter 7 problems"""

class Chap7Test(unittest.TestCase):
    def test_merge_empty_lists(self):
        self.assertEqual(None, ChapterSeven().merge(None, None))

    def test_merge_two_lists(self):
        l1, l2 = ListNode(1), ListNode(2)
        res = ChapterSeven().merge(l1, l2)
        self.assertEqual(1, res.val)
        res = res.next
        self.assertEqual(2, res.val)

    def test_find_not_cycle(self):
        l1 = ListNode(1)
        l1.next = ListNode(2)
        self.assertEqual(None, ChapterSeven().find_cycle(l1))


if __name__ == '__main__':
    unittest.main()

