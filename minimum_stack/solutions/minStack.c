#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct stacknode_int
{
	int iData;
	struct stacknode_int *pNextNode;
} stacknode_int;

typedef struct
{
	stacknode_int *pOrigStackTop;
	stacknode_int *pMinStackTop;
} minStackNode_int;

/* Allocates a node and sets its parameters */
static void createNewStackNode_Int(stacknode_int **ppNewNode, int iData, stacknode_int *pNextNode)
{
	*ppNewNode = (stacknode_int *)malloc(sizeof(stacknode_int));
	(*ppNewNode)->iData = iData;
	(*ppNewNode)->pNextNode = pNextNode;
}

bool isStackEmpty(stacknode_int *pTop)
{
	return (pTop == NULL);
}

bool peekFromStack(stacknode_int *pTop, int *ipData)
{
	if(isStackEmpty(pTop))
	{
		printf("ERR(Trying to peek): Stack Empty!\n");
		return false;
	}

	*ipData = pTop->iData;

	return true;
}

void printStack(stacknode_int *pTop)
{
	while(pTop != NULL)
	{
		printf("%d ", pTop->iData);
		pTop = pTop->pNextNode;
	}
}

void pushToMinStack(minStackNode_int *pStack, int iNewData)
{
	stacknode_int *pNewNode = NULL;
	int iMinStackData = 0;

	createNewStackNode_Int(&pNewNode, iNewData, (pStack->pOrigStackTop));
	pStack->pOrigStackTop = pNewNode;

	if(!isStackEmpty(pStack->pMinStackTop) && (iNewData > (pStack->pMinStackTop->iData)))
		iMinStackData = pStack->pMinStackTop->iData;
	else
		iMinStackData = iNewData;

	createNewStackNode_Int(&pNewNode, iMinStackData, (pStack->pMinStackTop));
	pStack->pMinStackTop = pNewNode;
}

bool popFromMinStack(minStackNode_int *pStack, int *ipPoppedData)
{
	stacknode_int *pOldTop = NULL;

	if(isStackEmpty(pStack->pOrigStackTop))
	{
		printf("ERR(Trying to pop): Stack Underflow!\n");
		return false;
	}

	pOldTop = pStack->pMinStackTop;
	pStack->pMinStackTop = pOldTop->pNextNode;
	free(pOldTop);

	pOldTop = pStack->pOrigStackTop;
	*ipPoppedData = pOldTop->iData;
	pStack->pOrigStackTop = pOldTop->pNextNode;
	free(pOldTop);

	return true;
}

bool getMinFromMinStack(minStackNode_int *pStack, int *ipPeekedData)
{
	return peekFromStack(pStack->pMinStackTop, ipPeekedData);
}

int main(void)
{
	minStackNode_int s;
	int iMin = 0, iDummy = 0;

	s.pMinStackTop = NULL;
	s.pOrigStackTop = NULL;

	pushToMinStack(&s, 15);
	pushToMinStack(&s, 20);
	pushToMinStack(&s, 10);

	getMinFromMinStack(&s, &iMin);
	printf("Stack content: ");
	printStack(s.pOrigStackTop);
	printf("\tMin: %d\n", iMin);

	pushToMinStack(&s, 5);
	getMinFromMinStack(&s, &iMin);
	printf("Stack content: ");
	printStack(s.pOrigStackTop);
	printf("\tMin: %d\n", iMin);

	popFromMinStack(&s, &iDummy);
	popFromMinStack(&s, &iDummy);
	getMinFromMinStack(&s, &iMin);
	printf("Stack content: ");
	printStack(s.pOrigStackTop);
	printf("\t\tMin: %d\n", iMin);
}