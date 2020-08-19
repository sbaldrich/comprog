class Solution:
    def threeSum(self, L: List[int]) -> List[List[int]]:
        n = len(L)
        if n < 3: return []
        L.sort()
        ans = []
        for i in range(n - 2):
            if i and L[i] == L[i - 1]:
                continue
            l, r = i + 1, n - 1
            while l < r:
                cur = L[i] + L[l] + L[r]
                if cur == 0:
                    ans.append([L[i], L[l], L[r]])
                    l, r = l + 1, r - 1 
                    while L[l] == L[l - 1] and l <= r: 
                        l += 1
                    while L[r + 1] == L[r] and r >= l: 
                        r -= 1
                elif cur < 0:
                    l += 1
                else:
                    r -= 1
        return ans
