#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_VERTICES 20

typedef struct Graph {
    int vertices;
    char** vertexNames;
    int** adjacencyMatrix;
} Graph;

Graph* createGraph(int vertices) {
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->vertices = vertices;

    graph->vertexNames = (char**)malloc(vertices * sizeof(char*));
    graph->adjacencyMatrix = (int**)malloc(vertices * sizeof(int*));

    for (int i = 0; i < vertices; i++) {
        graph->vertexNames[i] = (char*)malloc(50 * sizeof(char));
        graph->adjacencyMatrix[i] = (int*)malloc(vertices * sizeof(int));

        for (int j = 0; j < vertices; j++) {
            graph->adjacencyMatrix[i][j] = 0;
        }
    }
    return graph;
}

int findVertexIndex(Graph* graph, const char* vertexName) {
    for (int i = 0; i < graph->vertices; ++i) {
        if (strcmp(graph->vertexNames[i], vertexName) == 0) {
            return i;
        }
    }
    return -1;
}

void addEdge(Graph* graph, const char* start, const char* end) {
    int startIndex = findVertexIndex(graph, start);
    int endIndex = findVertexIndex(graph, end);

    if (startIndex != -1 && endIndex != -1) {
        graph->adjacencyMatrix[startIndex][endIndex] = 1;
        graph->adjacencyMatrix[endIndex][startIndex] = 1;
    }
    else {
        printf("Error: 未找到一个或多个顶点\n");
    }
}

void DFSUtil(Graph* graph, int vertex, bool* visited) {
    visited[vertex] = true;
    printf("%s ", graph->vertexNames[vertex]);
    for (int i = 0; i < graph->vertices; ++i) {
        if (graph->adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
            DFSUtil(graph, i, visited);
        }
    }
}

void DFS(Graph* graph, const char* startVertex) {
    bool* visited = (bool*)malloc(graph->vertices * sizeof(bool));
    for (int i = 0; i < graph->vertices; ++i) {
        visited[i] = false;
    }

    int startIndex = findVertexIndex(graph, startVertex);
    if (startIndex != -1) {
        printf("深度优先遍历 %s: ", startVertex);
        DFSUtil(graph, startIndex, visited);
        printf("\n");
    }
    else {
        printf("Error: 未找到起始顶点\n");
    }

    free(visited);
}

void BFS(Graph* graph, const char* startVertex) {
    bool* visited = (bool*)malloc(graph->vertices * sizeof(bool));
    for (int i = 0; i < graph->vertices; ++i) {
        visited[i] = false;
    }

    int startIndex = findVertexIndex(graph, startVertex);
    if (startIndex != -1) {
        printf("广度优先遍历 %s: ", startVertex);
        int queue[MAX_VERTICES];
        int front = 0, rear = -1;
        queue[++rear] = startIndex;
        visited[startIndex] = true;

        while (front <= rear) {
            int currentVertex = queue[front++];
            printf("%s ", graph->vertexNames[currentVertex]);

            for (int i = 0; i < graph->vertices; ++i) {
                if (graph->adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    queue[++rear] = i;
                    visited[i] = true;
                }
            }
        }
        printf("\n");
    }
    else {
        printf("Error: 未找到起始顶点\n");
    }

    free(visited);
}

void destroyGraph(Graph* graph) {
    for (int i = 0; i < graph->vertices; ++i) {
        free(graph->vertexNames[i]);
        free(graph->adjacencyMatrix[i]);
    }
    free(graph->vertexNames);
    free(graph->adjacencyMatrix);
    free(graph);
}

int main() {
    int vertices, edges;
    printf("输入顶点个数：");
    scanf("%d", &vertices);

    Graph* graph = createGraph(vertices);

    for (int i = 0; i < vertices; ++i) {
        printf("输入顶点 %d 的名字: ", i + 1);
        scanf("%s", graph->vertexNames[i]);
    }

    printf("输入边数：");
    scanf("%d", &edges);

    for (int i = 0; i < edges; ++i) {
        char start[50], end[50];
        printf("输入边的起始和结束顶点：");
        scanf("%s %s", start, end);
        addEdge(graph, start, end);
    }

    char startVertex[50];
    printf("输入遍历的起始顶点： ");
    scanf("%s", startVertex);

    DFS(graph, startVertex);
    BFS(graph, startVertex);

    destroyGraph(graph);

    return 0;
}
