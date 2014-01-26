#include <iostream>
#include <sstream>
#include <string>
#include <vector>


class Node {
public:
    Node() : value(-1), left(NULL), right(NULL) {
    }

    Node(int value) : left(NULL), right(NULL) {
        this->value = value;
    }

    Node* getLeft() { return left; }
    void setLeft(Node* node) { left = node; }
    Node* getRight() { return right; }
    void setRight(Node* node) { right = node; }
    int getValue() { return value; }

private:
    int value;
    Node* left;
    Node* right;
};

 
int main() {
    std::string tmp;
    while(std::getline(std::cin, tmp)) {
        std::vector<int> nums;
        std::istringstream ss(tmp);
        int ti;
        while (ss >> ti)
            nums.push_back(ti);

        for (std::vector<int>::const_iterator iter = nums.begin();
             iter != nums.end(); ++iter)
        {
            std::cout << *iter << " ";
        }
        std::cout << std::endl;
    }
}
