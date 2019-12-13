#include <SFML/Graphics.hpp>
#include<iostream>
#include<math.h>

using namespace std;

int WIDTH=500;
int HEIGHT=500;
int score=0;
float gap_between_blocks=100.0f;
float width_of_blocks=10.0f;
float shapeSize=20.0f;
int moveSpeed=10;
int frame_limit=100;

void config()
{
    int ch;
    cout<<"--------FLAPPY BIRD--------"<<endl;
    cout<<endl;
    cout<<endl;
    cout<<"         Created by Abir ganguly."<<endl;
    cout<<"Enter 1 for default configuration"<<endl;
    cout<<"Enter 0 to change configuration"<<endl;
    cin>>ch;
    switch(ch)
    {
    case 0:
        cout<<"Enter frame limit / speed / FPS: (DEFAULT=100)"<<endl;
        cin>>frame_limit;
        cout<<"Enter screen width: (DEFAULT=500)"<<endl;
        cin>>WIDTH;
        cout<<"Enter screen height: (DEFAULT=500)"<<endl;
        cin>>HEIGHT;
        cout<<"Enter gap between blocks: (DEFAULT=100)"<<endl;
        cin>>gap_between_blocks;
        cout<<"Enter width of blocks: (DEFAULT=10)"<<endl;
        cin>>width_of_blocks;
        cout<<"Enter bird size: (DEFAULT=20)"<<endl;
        cin>>shapeSize;
        cout<<"Enter move speed: (DEFAULT=10)"<<endl;
        cin>>moveSpeed;
        break;
    case 1:
        cout<<"Going for default configuration"<<endl;
        break;
    default:
        int x;
        cout<<"Wrong choice !!!"<<endl;
        cin>>x;
        exit(0);
    }
}

int main()
{
    config();
    /**
    Basically I do not know what does the statement:
            "srand((unsigned)time(NULL));"...
    means but I have used it because I have seen that everytime I
    run this program , then , the statement:
            "upBlocks[i]=rand();"...
    gives same random numbers if I do not give the statement (srand((unsigned...)
    , so I have used it...
                                        ...Abir Ganguly
    */
    srand((unsigned)time(NULL));
    int upBlocks[10];
    int downBlocks[10];
    int block_initial_position=WIDTH/2;
    int blockX[10];
    int i;
    for(i=0; i<=10; i++)
    {
        while(true)
        {
            upBlocks[i]=rand();
            downBlocks[i]=rand();
            if((upBlocks[i]<=(HEIGHT/2))&&(upBlocks[i]>=50))
            {
                if((downBlocks[i]<=(HEIGHT/2))&&(downBlocks[i]>=50))
                {
                    break;
                }
            }
        }
    }
    for(i=0; i<10; i++)
    {
        cout<<upBlocks[i]<<endl;
        cout<<downBlocks[i]<<endl;
    }
    int k=1;
    for(i=0; i<10; i++)
    {
        blockX[i]=block_initial_position+((width_of_blocks+gap_between_blocks)*k);
        k=k+1;
    }
    sf::RenderWindow window(sf::VideoMode(WIDTH,HEIGHT), "Created by Abir Ganguly...");
    window.setFramerateLimit(frame_limit);
    sf::RectangleShape shape(sf::Vector2f(shapeSize,shapeSize));
    shape.setFillColor(sf::Color::Green);
    int shapeX=0;
    int shapeY=0;
    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
            {
                window.close();
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Left))
            {
                if(shapeX>0)
                {
                    shape.move(-moveSpeed,0);
                    shapeX=shapeX-moveSpeed;
                }
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Right))
            {
                if(shapeX<(WIDTH-shapeSize))
                {
                    shape.move(moveSpeed,0);
                    shapeX=shapeX+moveSpeed;
                }
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Up))
            {
                if(shapeY>0)
                {
                    shape.move(0,-moveSpeed);
                    shapeY=shapeY-moveSpeed;
                }
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Down))
            {
                if(shapeY<(HEIGHT-shapeSize))
                {
                    shape.move(0,moveSpeed);
                    shapeY=shapeY+moveSpeed;
                }
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Escape))
            {
                window.close();
            }
        }
        window.clear(sf::Color(0,0,255,0));
        if(blockX[9]==0)
        {
            cout<<"Game ends !!!"<<endl;
            window.close();
        }
        for(i=0; i<10; i++)
        {
            if((shapeX+shapeSize)==blockX[i])
            {
                if((shapeY<=(upBlocks[i]-shapeSize)) || ((shapeY>=(HEIGHT-downBlocks[i]))))
                {
                    window.close();
                    cout<<"Game ends !!! (Touch with block)"<<endl;
                }
            }
        }
        for(i=0; i<10; i++)
        {
            sf::RectangleShape upBlock(sf::Vector2f(width_of_blocks,upBlocks[i]));
            sf::RectangleShape downBlock(sf::Vector2f(width_of_blocks,downBlocks[i]));
            upBlock.setPosition(blockX[i],0);
            downBlock.setPosition(blockX[i],(HEIGHT-downBlocks[i]));
            window.draw(upBlock);
            window.draw(downBlock);
        }
        window.draw(shape);
        window.display();
        for(i=0; i<10; i++)
        {
            if(shapeX==blockX[i])
            {
                score=score+10;
                cout<<"Score="<<score<<endl;
            }
        }
        for(i=0; i<10; i++)
        {
            blockX[i]=blockX[i]-1;
        }
    }
    return 0;
}
