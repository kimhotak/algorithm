import sys, math

trees = tuple(map(int, sys.stdin.read().split()[1:]))
dist_btwn_trees = tuple(trees[i+1]-trees[i] for i in range(len(trees)-1))
dist = math.gcd(*dist_btwn_trees)
print(sum(d//dist-1 for d in dist_btwn_trees))