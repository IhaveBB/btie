	#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define MaxSize 10

// 全局数组变量visited初始化
int visited[MaxSize] = { 0 };

// 图中顶点的数据类型，假设为char型
typedef char DataType;

// 边的结构体
typedef struct
{
    int start;  // 边的起点
    int end;    // 边的终点
    int weight; // 边的权值
} Edge;

// 定义邻接矩阵存储结构
typedef struct
{
    DataType vertex[MaxSize];     // 存放顶点的一维数组
    int edge[MaxSize][MaxSize];   // 存放边的二维数组
    int vertexNum, edgeNum;       // 图的顶点数和边数
} MGraph;

// 创建图
void CreatGraph(MGraph* G, DataType a[], int n, int e)
{
    int i, j, k;
    G->vertexNum = n;
    G->edgeNum = e;

    // 存储顶点信息
    for (i = 0; i < G->vertexNum; i++)
        G->vertex[i] = a[i];

    // 初始化邻接矩阵
    for (i = 0; i < G->vertexNum; i++)
        for (j = 0; j < G->vertexNum; j++)
            G->edge[i][j] = 0;

    // 依次输入每一条边
    for (k = 0; k < G->edgeNum; k++)
    {
        printf("输入边依附的顶点编号:");
        scanf("%d%d", &i, &j); // 输入边依附的顶点编号
        G->edge[i][j] = 1;
        G->edge[j][i] = 1; // 置有边标志
    }
}

// 深度优先遍历
void DFTraverse(MGraph* G, int v)
{
    int j;
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    for (j = 0; j < G->vertexNum; j++)
        if (G->edge[v][j] == 1 && visited[j] == 0)
            DFTraverse(G, j);
}

// 广度优先遍历
void BFTraverse(MGraph* G, int v)
{
    int i, j, Q[MaxSize]; // 采用顺序队列，存储顶点编号
    int front = -1;
    int rear = -1; // 初始化顺序队列
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    Q[++rear] = v;
    while (front != rear) // 当队列非空时
    {
        i = Q[++front]; // 将队头元素出队并送到v中
        for (j = 0; j < G->vertexNum; j++)
            if (G->edge[i][j] == 1 && visited[j] == 0)
            {
                printf("%c ", G->vertex[j]);
                visited[j] = 1;
                Q[++rear] = j;
            }
    }
}

// 打印无向图的邻接矩阵
void PrintAdjacencyMatrix(MGraph* G)
{
    for (int i = 0; i < G->vertexNum; i++)
    {
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (G->edge[i][j] == 1)
                printf("1");
            else
            {
                printf("0");
            }
        }
        printf("\n");
    }
}

// Prim算法生成最小生成树
void Prim(MGraph* G, int start)
{
    int lowCost[MaxSize];  // 存储到已选顶点集合的最小边权值
    int minIndex;          // 存储最小权值边所连接的顶点编号

    // 初始化lowCost数组
    for (int i = 0; i < G->vertexNum; i++)
    {
        lowCost[i] = G->edge[start][i];
    }

    visited[start] = 1;  // 将起始顶点加入已选顶点集合

    printf("\nPrim算法生成的最小生成树边集合为：\n");

    for (int i = 1; i < G->vertexNum; i++)
    {
        int min = INT_MAX;

        // 选出最小权值边
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (lowCost[j] < min && visited[j] == 0)
            {
                min = lowCost[j];
                minIndex = j;
            }
        }

        visited[minIndex] = 1;  // 将最小权值边连接的顶点加入已选顶点集合

        printf("(%c, %c) ", G->vertex[start], G->vertex[minIndex]);

        // 更新lowCost数组
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (G->edge[minIndex][j] < lowCost[j] && visited[j] == 0)
            {
                lowCost[j] = G->edge[minIndex][j];
            }
        }
    }
}

// 查找并查集的根节点
int findRoot(int parent[], int i)
{
    while (parent[i] != i)
    {
        i = parent[i];
    }
    return i;
}

// Kruskal算法生成最小生成树
void Kruskal(MGraph* G)
{
    Edge edges[MaxSize * MaxSize]; // 存储所有边的数组
    int edgeCount = 0;

    // 将图的边存入edges数组
    for (int i = 0; i < G->vertexNum; i++)
    {
        for (int j = i + 1; j < G->vertexNum; j++)
        {
            if (G->edge[i][j] != 0)
            {
                edges[edgeCount].start = i;
                edges[edgeCount].end = j;
                edges[edgeCount].weight = G->edge[i][j];
                edgeCount++;
            }
        }
    }

    // 对边按权值升序排序
    for (int i = 0; i < edgeCount - 1; i++)
    {
        for (int j = 0; j < edgeCount - i - 1; j++)
        {
            if (edges[j].weight > edges[j + 1].weight)
            {
                Edge temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }

    printf("\nKruskal算法生成的最小生成树边集合为：\n");

    // 初始化并查集数组
    int parent[MaxSize];
    for (int i = 0; i < G->vertexNum; i++)
    {
        parent[i] = i;
    }

    // 遍历所有边
    for (int i = 0; i < edgeCount; i++)
    {
        int root1 = findRoot(parent, edges[i].start);
        int root2 = findRoot(parent, edges[i].end);

        // 如果两个顶点不在同一集合中，加入最小生成树
        if (root1 != root2)
        {
            printf("(%c, %c) ", G->vertex[edges[i].start], G->vertex[edges[i].end]);

            // 合并两个集合
            parent[root1] = root2;
        }
    }
}

int main()
{
    int vertex = 0;
    printf("输入无向图的顶点数\n");
    scanf("%d", &vertex);

    int number = 0;
    printf("输入无向图的边数\n");
    scanf("%d", &number);

    int i;
    char ch[MaxSize];

    printf("请输入顶点信息");
    for (int i = 0; i < vertex; i++)
    {
        scanf(" %c", &ch[i]); // 注意%c前的空格
    }

    MGraph MG;
    CreatGraph(&MG, ch, vertex, number);

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("无向图的邻接矩阵为\n");
    PrintAdjacencyMatrix(&MG);

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("深度优先遍历序列是：\n");
    DFTraverse(&MG, 0); // 从顶点0出发进行深度优先遍历

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;
    printf("\n");
    printf("广度优先遍历序列是：\n");
    BFTraverse(&MG, 0); // 从顶点0出发进行广度优先遍历

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    // Prim算法生成最小生成树
    printf("\n");
    Prim(&MG, 0);

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    // Kruskal算法生成最小生成树
    printf("\n");
    Kruskal(&MG);

    return 0;
}
