#include <stdio.h>

int main(void)
{
	int a, x;
	int arr[10000];
	int i, j;
	scanf("%d %d", &a, &x);
	if (a <= 10000 && a >=1 && x<=10000)
	{
		for (i = 0; i < a; i++)
		{
			scanf("%d", &arr[i]);
		}
		for (i = 0; i < a; i++)
		{
			if (arr[i] < x)
			{
				printf("%d ", arr[i]);
			}
		}
	}	return 0;
}