#include <iostream>
#include <cstdlib>
#include <ctime>

int main()
{
    int n, start, end, i;

	std::cout<<"Enter number of randoms : "<<std::endl;
	std::cin>>n;

	std::cout<<"Enter start : "<<std::endl;
	std::cin>>start;

	std::cout<<"Enter end : "<<std::endl;
	std::cin>>end;

	srand(time(0));

	for(i=1;i<=n;i++)
    {
        std::cout<<(start + (rand() % 6))<<std::endl;;
    }
    system("pause");
	return 0;
}
