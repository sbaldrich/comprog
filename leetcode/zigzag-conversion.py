from heapq import heappush, heappop

class Solution:
    def convert(self, s: str, r: int) -> str:
        n = len(s)
        ans = []
        row, zig = 0, True
        for i, c in enumerate(s):
            heappush(ans, (row * 1000 + i, i))
            if zig:
                row += 1
            else: row -= 1
            if row == r - 1 or row == 0:
                zig = not zig
        return ''.join([s[heappop(ans)[1]] for i in range(n)])
