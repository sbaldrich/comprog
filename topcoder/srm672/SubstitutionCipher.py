import string


class SubstitutionCipher:
    def decode(self, a, b, y):
        table = {}
        for c, d in zip(a, b):
            prev = table.get(d, '.')
            if(prev != '.' and prev != c):
                return ''
            table[d] = c
        ans = ''

        if(len(table) == 25):
            alpha = set(string.ascii_uppercase)
            s = (alpha - set(table.values())).pop()
            t = (alpha - set(table.keys())).pop()
            table[t] = s

        for c in y:
            nxt = table.get(c, '.')
            if(nxt == '.'):
                return ''
            ans += table[c]

        return ans
