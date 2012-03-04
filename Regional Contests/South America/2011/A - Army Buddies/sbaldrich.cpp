/*
 *   Created on: Feb 3, 2012
 *   Author: sbaldrich
 *   Problem: A - Army Buddies
 *
 *   The problem ressembles a Linked List data structure. Each soldier must know who is his neighbor
 *   on each side. Just update on each bomb. I tried to do this in Java but, nope. Tle.
 */

#include<cstdio>

using namespace std;

int main() {
	//freopen("A.in", "r", stdin);
	int S, B, MAX = 100002, x, y;
	int right[MAX], left[MAX];
	while (scanf("%d %d", &S, &B) != -1 && S!=0) {
		for (int i = 1; i <= S; i++)
			right[i] = i + 1, left[i] = i - 1;
		for (int i = 0; i < B; i++) {
			scanf("%d %d", &x, &y);
			if (left[x] != 0)
				printf("%d ", left[x]);
			else
				printf("* ");
			if (right[y] != S+1)
				printf("%d\n", right[y]);
			else
				printf("*\n");
			right[left[x]] = right[y];
			left[right[y]] = left[x];
		}
		printf("-\n");
	}

	return 0;
}

