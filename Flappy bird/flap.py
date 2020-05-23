import pygame, sys
import random
from pygame.locals import *
pygame.init()
FPS = 30
fpsClock = pygame.time.Clock()
DISPLAYSURF = pygame.display.set_mode((950,400))
d=DISPLAYSURF
green=(0,255,0)
red=(255,0,0)
white=(255,255,255)
d.fill(white)
pygame.display.set_caption('CREATED BY ABIR GANGULY')
i=1
length_of_rand=10
length_of_rand1=10
rand=[0]*length_of_rand
rand1=[0]*length_of_rand1
for i in range(10):
    rand[i]=random.choice(range(100,300))
for i in range(10):
    rand1[i]=random.choice(range(100,300))
i=2000    #down blocks
i1=2100   #up blocks
plposx=0
plposy=0
score=0
print("Score =",score)
while True:
    if score==20:
        print("YOU WON !!!")
        pygame.quit()
        sys.exit()
    i=i-1
    i1=i1-1
    j=0
    d.fill(white)
    pygame.draw.rect(d,green,(plposx,plposy,10,10))
    for j in range(10):
        if plposx>2100:
            print("Score =",score)
            pygame.quit()
            sys.exit()
        elif (plposx+10)==(i1-(200*j)) and plposy<(400-rand1[j]):
            print("Score =",score)
            print("YOU LOSE !!!")
            pygame.quit()
            sys.exit()
        elif (plposx+10)==(i-(200*j)) and plposy>rand[j]:
            print("Score =",score)
            print("YOU LOSE !!!")
            pygame.quit()
            sys.exit()
        elif (plposx+10)==(i-(200*j)) or (plposx+10)==(i1-(200*j)):
            score=score+1
            print("Score =",score)
        pygame.draw.rect(d,red,((i1-(200*j)),0,50,(400-rand1[j]))) #UP BLOCKS
        pygame.draw.rect(d,red,((i-(200*j)),rand[j],50,(400-rand[j]))) #DOWN BLOCKS
    for event in pygame.event.get():
        if event.type==KEYDOWN:
            if event.key==K_ESCAPE:
                pygame.quit()
                sys.exit()
            if event.key==K_RIGHT:
                if plposx>=940:
                    plposx=940
                else:
                    plposx=plposx+10
                pygame.draw.rect(d,white,((plposx-10),plposy,10,10))
                pygame.draw.rect(d,green,(plposx,plposy,10,10))
            if event.key==K_LEFT:
                if plposx<=0:
                    plposx=0
                else:
                    plposx=plposx-10
                pygame.draw.rect(d,white,((plposx+10),plposy,10,10))
                pygame.draw.rect(d,green,(plposx,plposy,10,10))
            if event.key==K_UP:
                if plposy<=0:
                    plposy=0
                else:
                    plposy=plposy-10
                pygame.draw.rect(d,white,(plposx,(plposy+10),10,10))
                pygame.draw.rect(d,green,(plposx,plposy,10,10))
            if event.key==K_DOWN:
                if plposy>=390:
                    plposy=390
                else:
                    plposy=plposy+10
                pygame.draw.rect(d,white,(plposx,(plposy-10),10,10))
                pygame.draw.rect(d,green,(plposx,plposy,10,10))
            for j in range(10):
                if plposx>2100:
                    print("Score =",score)
                    pygame.quit()
                    sys.exit()
                elif (plposx+10)==(i1-(200*j)) and plposy<(400-rand1[j]):
                    print("Score =",score)
                    print("YOU LOSE !!!")
                    pygame.quit()
                    sys.exit()
                elif (plposx+10)==(i-(200*j)) and plposy>rand[j]:
                    print("Score =",score)
                    print("YOU LOSE !!!")
                    pygame.quit()
                    sys.exit()
                elif (plposx+10)==(i-(200*j)) or (plposx+10)==(i1-(200*j)):
                    score=score+1
                    print("Score =",score)
        if event.type == QUIT:
            pygame.quit()
            sys.exit()
    pygame.display.update()
    fpsClock.tick(FPS)
