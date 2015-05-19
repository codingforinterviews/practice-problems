#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct sll_int_node
{
	int iData;
	struct sll_int_node *pNextNode;
} sll_int_node;

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

bool detectLoop_Sll(sll_int_node *pHead)
{
	sll_int_node *pSlow = pHead;
	sll_int_node *pFast = pHead;

	if(pHead != NULL)
	{
		while((pFast->pNextNode != NULL) && (pFast->pNextNode->pNextNode != NULL))
		{
			pSlow = pSlow->pNextNode;
			pFast = pFast->pNextNode->pNextNode;

			if(pSlow == pFast)
				return true;
		}
	}
	else
		printf("ERR(detectLoop): List is empty\n");

	return false;
}

int main(void)
{
	sll_int_node *head = NULL;

	insertFrontIntNode_Sll(&head, 1);
	insertFrontIntNode_Sll(&head, 2);
	insertFrontIntNode_Sll(&head, 3);
	insertFrontIntNode_Sll(&head, 4);
	insertFrontIntNode_Sll(&head, 5);

	/* Before inserting loop */
	printf("List contains loop: %s\n", detectLoop_Sll(head) ? "true" : "false");
	
	head->pNextNode->pNextNode->pNextNode->pNextNode->pNextNode = head->pNextNode->pNextNode;
	
	/* After inserting loop */
	printf("List contains loop: %s\n", detectLoop_Sll(head) ? "true" : "false");
	
	return 0;
}