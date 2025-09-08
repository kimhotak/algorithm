import sys
from math import gcd

trees = list(map(int, sys.stdin.read().split()[1:]))
dist_btwn_trees = list(trees[i+1]-trees[i] for i in range(len(trees)-1))
dist = gcd(*dist_btwn_trees)
print(sum(d//dist-1 for d in dist_btwn_trees))