class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        memo = {}
        for index, n in enumerate(nums):
            if target - n in memo:
                return [memo[target - n], index]
            memo[n] = index
        return []

