class SetPartialOrder:
    def compareSets(self, a, b):
        a = set(a)
        b = set(b)
        if(a <= b and b <= a):
            return "EQUAL"
        if(a <= b):
            return "LESS"
        if(b <= a):
            return "GREATER"
        return "INCOMPARABLE"
