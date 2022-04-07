import sys

n = sys.stdin.readline().strip()

print("".join((s for s in sorted(n,reverse=True))))