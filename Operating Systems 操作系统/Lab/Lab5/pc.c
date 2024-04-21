#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
 
#define PRO_NUM 3   //Number of producer thread
#define CON_NUM 2   //Number of consumer thread
pthread_cond_t n_full;
pthread_cond_t n_empty;
pthread_mutex_t mutex;
 
int g_num = 0;      //Number of products
int empty_num = 3;  //Size of buffer
 
//producer
void* pro_route(void* arg)
{
// Write producer code here:







}


//consumer
void *con_route(void* arg)
{
// Write consuder code here：
 
 
 
 
 
 

}



int main( )
{
    srand(getpid());
 
    pthread_t tids[PRO_NUM + CON_NUM];
    
	//Initialize mutex and condition variables
    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&n_full, NULL);   //Condition varible n_full
    pthread_cond_init(&n_empty, NULL); //Condition variable n_empty
 
    //Create producer thread
    for(int i =0; i< PRO_NUM; ++i)
    {
        int* p = (int*)malloc(sizeof(int)); //传入参数相当作线程编号
        *p = i;
        pthread_create(&tids[i], NULL, pro_route, p);
    }
    //Create consumer thread
    for(int i =0; i< CON_NUM; ++i)
    {
        int* p = (int*)malloc(sizeof(int)); 
        *p = i;
        pthread_create(&tids[i], NULL, con_route, p);
    }
    for(int i =0; i< PRO_NUM + CON_NUM; ++i) 
    {
        pthread_join(tids[i], NULL);
    }
    	
    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&n_full);
    pthread_cond_destroy(&n_empty);
 
    return 0;
}