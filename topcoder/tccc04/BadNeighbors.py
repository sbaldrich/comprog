
memo = dict()


def f(donations):
    if(tuple(donations) in memo):
        return memo[tuple(donations)]
    if(len(donations) == 0):
        return 0
    if(len(donations) < 3):
        return max(donations)
    if(len(donations) == 3):
        return max(donations[0] + donations[2], donations[1])
    memo[tuple(donations)] = max(donations[0] + f(donations[2:]),
                                 f(donations[1:]))
    return memo[tuple(donations)]


class BadNeighbors:
    def maxDonations(self, donations):
        return max(f(donations[1:-1]), donations[0] + f(donations[2:-1]),
                   donations[-1] + f(donations[1:-2]))
