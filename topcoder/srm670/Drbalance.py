class Drbalance:
    def lesscng(self, s, k):
        s = list(s)

        def neg(s):
            n = 0
            for i in range(1, len(s)+1):
                n += s[:i].count('+') < s[:i].count('-')
            return n
        ans = 0
        while(neg(s) > k):
            s[s.index('-')] = '+'
            ans += 1
        return ans
