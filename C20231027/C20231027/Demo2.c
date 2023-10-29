#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct BinaryTreeNode {
    char data;
    struct BinaryTreeNode* left;
    struct BinaryTreeNode* right;
};

struct BinaryTreeNode* createBinaryTree(char* input, int* index) {
    if (input[*index] == '#') {
        return NULL;
    }

    if (input[*index] != '@') {
        struct BinaryTreeNode* root = (struct BinaryTreeNode*)malloc(sizeof(struct BinaryTreeNode));
        root->data = input[*index];
        (*index)++;
        root->left = createBinaryTree(input, index);
        root->right = createBinaryTree(input, index);
        return root;
    }
    //

    (*index)++; 
    return NULL;
}

void preorderTraversal(struct BinaryTreeNode* root) {
    if (root != NULL) {
        printf("%c", root->data);
        preorderTraversal(root->left);
        preorderTraversal(root->right);
    }
}

void inorderTraversal(struct BinaryTreeNode* root) {
    if (root != NULL) {
        inorderTraversal(root->left);
        printf("%c", root->data);
        inorderTraversal(root->right);
    }
}

void postorderTraversal(struct BinaryTreeNode* root) {
    if (root != NULL) {
        postorderTraversal(root->left);
        postorderTraversal(root->right);
        printf("%c", root->data);
    }
}

void freeBinaryTree(struct BinaryTreeNode* root) {
    if (root == NULL) {
        return;
    }
    freeBinaryTree(root->left);
    freeBinaryTree(root->right);
    free(root);
}

int main() {
    char arr[] = "A@CD#";
    int index = 0;
    struct BinaryTreeNode* root = createBinaryTree(arr, &index);

    printf("前序遍历: ");
    preorderTraversal(root);
    printf("\n");

    printf("中序遍历: ");
    inorderTraversal(root);
    printf("\n");

    printf("后序遍历: ");
    postorderTraversal(root);
    printf("\n");

    // Free allocated memory
    freeBinaryTree(root);

    return 0;
}
