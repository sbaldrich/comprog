class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        window_start, best_len = 0, 0
        for i, c in enumerate(s):
            if c in seen and seen[c] >= window_start:
                window_start = seen[c] + 1
            best_len = max(best_len, i - window_start + 1)
            seen[c] = i
        return best_len
