#include <stdio.h>
#include <stdlib.h>

/* Stack definitions. We'll use char for all our values as it's convenient for
   the question. */
struct Stack {
	struct StackFrame *top;
	unsigned int size;
};
typedef struct Stack Stack_t;

struct StackFrame {
	struct StackFrame *prev;
	char val;
};
typedef struct StackFrame Frame_t;

/* Stack methods. */
void push(Stack_t *s, char v) {
	Frame_t *prev_top;

	prev_top = s->top;
	s->top = (Frame_t*) malloc(sizeof(Frame_t));
	s->top->prev = prev_top;
	s->top->val = v;
	s->size++;
}

char pop(Stack_t *s) {
	char v;
	Frame_t *p;

	v = s->top->val;
	p = s->top->prev;
	free(s->top);
	s->top = p;
	s->size--;
	return v;
}

/* Some convenience functions for checking that delimiters are of the correct
   type for eachother. */
int matches(char opener, char closer) {
	switch(opener) {
		case '(':
			if (closer == ')') return 1;
		case '[':
			if (closer == ']') return 1;
		case '{':
			if (closer == '}') return 1;
		default:
			return 0;
	}
}

int opener(char c) {
	switch(c) {
		case '(':
		case '[':
		case '{':
			return 1;
		default:
			return 0;
	}
}

int main() {
	Stack_t *s = (Stack_t*) malloc(sizeof(Stack_t));
	char delim;

	/* Scan characters until we get to the end of the input. */
	while(scanf("%c", &delim) > 0) {
		if(opener(delim)) {
			push(s, delim);
		} else {
			if(!matches(pop(s), delim)) {
				/* There was an overlapping/wrong delimiter. */
				printf("False");
				return 0;
			}
		}
	}
	
	if(s->size) {
		/* If our stack isn't empty, there were unclosed delimiters. */
		printf("False");
	} else {
		printf("True");
	}

	return 0;
}
