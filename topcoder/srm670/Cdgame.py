class Cdgame:
    def rescount(self, a, b):
        sa = sum(a)
        sb = sum(b)
        s = set()
        for i in a:
            for j in b:
                s.add((sa-i+j)*(sb-j+i))
        return len(s)
