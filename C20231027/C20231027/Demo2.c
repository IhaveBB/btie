#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct BinaryTreeNode {
    char data;
    struct BinaryTreeNode* left;
    struct BinaryTreeNode* right;
};

struct Queue {
    struct BinaryTreeNode* data;
    struct Queue* next;
};

// 队列结构的初始化
void initQueue(struct Queue* q) {
    q->data = NULL;
    q->next = NULL;
}

// 检查队列是否为空
int isQueueEmpty(struct Queue* q) {
    return q->data == NULL;
}

// 入队
void enqueue(struct Queue* q, struct BinaryTreeNode* data) {
    struct Queue* newNode = (struct Queue*)malloc(sizeof(struct Queue));
    newNode->data = data;
    newNode->next = NULL;
    if (q->data == NULL) {
        q->data = data;
        q->next = NULL;
    }
    else {
        struct Queue* current = q;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newNode;
    }
}

// 出队
struct BinaryTreeNode* dequeue(struct Queue* q) {
    if (isQueueEmpty(q)) {
        return NULL;
    }
    else {
        struct BinaryTreeNode* data = q->data;
        struct Queue* temp = q;
        q = q->next;
        free(temp);
        return data;
    }
}

struct BinaryTreeNode* createBinaryTree(char* input) {
    struct BinaryTreeNode* root = NULL;
    struct Queue q;
    initQueue(&q);

    int i = 0;
    while (input[i] != '#') {
        if (input[i] == '@') {
            i++;
            continue; // Skip empty nodes
        }

        struct BinaryTreeNode* node = (struct BinaryTreeNode*)malloc(sizeof(struct BinaryTreeNode));
        node->data = input[i];
        node->left = NULL;
        node->right = NULL;

        if (root == NULL) {
            root = node;
            enqueue(&q, root);
        }
        else {
            struct BinaryTreeNode* current = dequeue(&q);
            if (current->left == NULL) {
                current->left = node;
                enqueue(&q, node);
            }
            else if (current->right == NULL) {
                current->right = node;
                enqueue(&q, node);
            }
        }
        i++;
    }

    return root;
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


int main2() {
    char arr[] = "ABCDEFG@@J@@I#"; // 请根据需要提供正确的输入数据
    struct BinaryTreeNode* root = createBinaryTree(arr);

    printf("前序遍历: ");
    preorderTraversal(root);
    printf("\n");

    printf("中序遍历: ");
    inorderTraversal(root);
    printf("\n");

    printf("后序遍历: ");
    postorderTraversal(root);
    printf("\n");

    // 释放分配的内存
    freeBinaryTree(root);

    return 0;
}
