#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	int iData;
	struct sll_int_node *pNextNode;
} sll_int_node;

void reverseList_Iter_Sll(sll_int_node **ppHead)
{
	sll_int_node *pPrev = NULL;
	sll_int_node *pCurr = *ppHead;
	sll_int_node *pNext = NULL;

	if(*ppHead != NULL)
	{
		while(pCurr != NULL)
		{
			pNext = pCurr->pNextNode;
			pCurr->pNextNode = pPrev;

			pPrev = pCurr;
			pCurr = pNext;
		}

		*ppHead = pPrev;
	}
	else
		printf("ERR(reverseList_Iter_Sll): List is empty\n");
}

sll_int_node * reverseSubList_Sll(sll_int_node *pPrev, sll_int_node *pCurr)
{
	sll_int_node *pNewHead;

	if(pCurr->pNextNode == NULL)
	{
		pCurr->pNextNode = pPrev;
		return pCurr;
	}

	pNewHead = reverseSubList_Sll(pCurr, pCurr->pNextNode);
	pCurr->pNextNode = pPrev;

	return pNewHead;
}

void reverseList_Recur_Sll(sll_int_node **ppHead)
{
	if(*ppHead != NULL)
	{
		*ppHead = reverseSubList_Sll(NULL, *ppHead);
	}
	else
		printf("ERR(reverseList_Recur_Sll): List is empty\n");
}

/* Allocates a node and sets its parameters */
void createNewIntNode_Sll(sll_int_node **ppNewNode, int iData, sll_int_node *pNextNode)
{
	*ppNewNode = (sll_int_node *)malloc(sizeof(sll_int_node));
	(*ppNewNode)->iData = iData;
	(*ppNewNode)->pNextNode = pNextNode;
}

void printList_Sll(sll_int_node *pHead)
{
	while(pHead != NULL)
	{
		printf("%d ", pHead->iData);
		pHead = pHead->pNextNode;
	}
}

/* Insert to the start of the list */
void insertFrontIntNode_Sll(sll_int_node **ppHead, int iNewData)
{
	sll_int_node *pNewNode = NULL;

	createNewIntNode_Sll(&pNewNode, iNewData, *ppHead);

	*ppHead = pNewNode;
}

int main(void)
{
	sll_int_node *head1 = NULL, *head2 = NULL;

	insertFrontIntNode_Sll(&head1, 1);
	insertFrontIntNode_Sll(&head1, 2);
	insertFrontIntNode_Sll(&head1, 3);
	insertFrontIntNode_Sll(&head1, 4);
	
	insertFrontIntNode_Sll(&head2, -1);
	insertFrontIntNode_Sll(&head2, -2);
	insertFrontIntNode_Sll(&head2, -3);
	insertFrontIntNode_Sll(&head2, -4);

	printf("List1: ");
	printList_Sll(head1);
	printf("\n");

	reverseList_Iter_Sll(&head1);
	printf("Reversed List1 (Iterative): ");
	printList_Sll(head1);
	printf("\n");
	
	printf("List2: ");
	printList_Sll(head2);
	printf("\n");

	reverseList_Recur_Sll(&head2);
	printf("Reversed List2 (Iterative): ");
	printList_Sll(head2);
	printf("\n");
	
	return 0;
}