#!/usr/bin/env python

'''
Problem 7.2
Detect cycle in linked list
'''

def find_cycle(head):
    if not head or not head.next:
        return None
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            slow = head
            while slow is not fast:
                slow = slow.next
                fast = fast.next
            return slow
    return None
