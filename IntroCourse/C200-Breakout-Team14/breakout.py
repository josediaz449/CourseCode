#Jamar Golden
#jose Diaz
import sys, pygame
from random import *

pygame.init()

#Dimensions of the window
winHeight = 500
winWidth = 800

#fonts
myfont = pygame.font.SysFont("monospace", 25)
pauseFont = pygame.font.SysFont('Time New Roman', 100)
myFont = pygame.font.SysFont('Time New Roman', 50)

#Color variables 
white = (255, 255, 255)
black = (0, 0, 0)

#This code sets the dimensions of the window as well as the name of the window
display = pygame.display.set_mode((winWidth, winHeight))
pygame.display.set_caption("BreakOut")
clock = pygame.time.Clock()

#false statements
gameover = False
loselife = False
breakOut = False
lvl = False
winner = False
pause = False

#Dictionary
dic = {pygame.K_a: "A", pygame.K_b: "B", pygame.K_c: "C", pygame.K_d: "D", pygame.K_e: "E", pygame.K_f: "F", pygame.K_g: "G", pygame.K_h: "H",
       pygame.K_i: "I", pygame.K_j: "J", pygame.K_k: "K", pygame.K_l: "L", pygame.K_m: "M", pygame.K_n: "N", pygame.K_o: "O", pygame.K_p: "P",
       pygame.K_q: "Q", pygame.K_r: "R", pygame.K_s: "S", pygame.K_t: "T", pygame.K_u: "U", pygame.K_v: "V", pygame.K_w: "W", pygame.K_x: "X",
       pygame.K_y: "Y", pygame.K_z: "Z"}

#counters
lvlCounter = 1
lives = 3
hitCounter = 1
colorCount = 0
brickCount = 0

#Leader
initials = ""
initCount = 0
Surface23 = myfont.render("Input your initials (3 Letters):   ", False, white)
leaders = False
#brick images 
colors = [pygame.image.load('Brick.png'), pygame.image.load('Blue Brick.png'), pygame.image.load('Green Brick.png'), 
          pygame.image.load('Orange Brick.png'), pygame.image.load('Purple Brick.png')]
BrickImg = pygame.image.load('Brick.png')

#classes
class Brick:
    def __init__(self, x_cord, y_cord):
        self.x = x_cord
        self.y = y_cord
        self.visibility = True
        self.brick = pygame.image.load('Brick.png')
        self.make_brick()
    def make_brick(self):
        return display.blit(BrickImg, (self.x, self.y))
    def getBrickx(self):
        return self.x
    def getBricky(self):
        return self.y
    def getBrick(self):
        return self.brick
    def __str__(self):
        return 
    
class Paddle:
    
    def __init__(self, init_x, init_y):
        self.padx = init_x
        self.pady = init_y
        self.paddle = pygame.image.load('Paddle.png')
    def make_paddle(self):
        return display.blit(self.paddle, (self.padx, self.pady))
    def getPadx(self):
        return self.padx
    def getPady(self):
        return self.pady
    def getPad(self):
        return self.paddle

class Ball:
    def __init__(self, place_x, place_y):
        self.place_x = place_x
        self.place_y = place_y
        self.ball = pygame.image.load('Ball.png')
    def make_ball(self):
        return display.blit(self.ball, (self.place_x, self.place_y))
    def getBall(self):
        return self.ball
    def getX(self):
        return self.place_x
    def getY(self):
        return self.place_y




#Paddle Code
x = 0
y = (winHeight * 0.2)
px = (winWidth * 0.45)
dx = (winWidth * 0.45)
x_change = 0
x2_change = 7

#Bricksquad
brick1 = Brick(x, y)
brick1rect = BrickImg.get_rect()

Bricks1 = []
Bricks2 = []
def createBrick(x, y):
    for i in range(0, 21):
        if i < 10:
            newBrick = Brick((80 * i), (winHeight * 0.2))
            x.append(newBrick)
        elif i > 9:
            newBrick = Brick(((80 * (i - 10))-40), ((winHeight * 0.2)-25))
            y.append(newBrick)

    return x, y
createBrick(Bricks1, Bricks2)
BRects = []
def CreateBrects(x):
    for i in range(0, 21):
        newRect = BrickImg.get_rect()
        x.append(newRect)
    return x
CreateBrects(BRects)

#list of hits on bricks
hits = []
def hit(x):
    for i in range(0, 21):
        new = 0
        x.append(new)
    return x
hit(hits)


#Ball Code
random = randint(200, 600)
ballClass = Ball(random, 150)
ball = Ball.getBall(Ball(ballClass.place_x, ballClass.place_y))
ballrect = ball.get_rect()
ballrect.x = Ball.getX(Ball(ballClass.place_x, ballClass.place_y))
ballrect.y = Ball.getY(Ball(ballClass.place_x, ballClass.place_y))
speed = [3,3]
speed2 = [-4,-2,-3,-4,-2,-5,1,-6]
speed3 = [3,0]


#time variables
min = 0
sec = 0
milsec = 0
time = "0:00"

#game start screen
def game_start():

    start = True

    while start:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        display.fill(white)
        title = myFont.render("BREAKOUT", 1, black)
        label = myfont.render("Press S to start", 1, black)
        inst = myfont.render("Use left and right arrow to move paddle", 1, black)
        inst2 = myfont.render("Hit the bricks to get through.", 1, black)
        inst3 = myfont.render("Pass all 5 levels to win.", 1, black)
        display.blit(inst, (25, 250))
        display.blit(inst2, (25, 275))
        display.blit(inst3, (25, 300))
        display.blit(label, (250, 100))
        display.blit(title, (250, 10))
        pygame.display.update()
        clock.tick(15)
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_s:
                start = False

game_start()

#main game loop
while True:

#level screen
    while lvl == True:
        leaderboards = open("Leader.txt", "a")
        if lvlCounter == "6":
            winner = True
            lvl = False 
        lvlCounter = str(lvlCounter)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
        display.fill(white)
        label = myfont.render("level " + lvlCounter, 1, black)
        cont = myfont.render("press [C] to continue", 1, black)
        display.blit(label, (350, 100))
        display.blit(cont, (250, 200))
        pygame.display.update()
        clock.tick(15)
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_c:
                Bricks1 = []
                Bricks2 = []
                createBrick(Bricks1, Bricks2)
                hitCounter += 1
                hits = []
                hit(hits)
                lvl = False
               
#Winner Screen            
    while winner == True:
        leaderboards = open("Leader.txt", "a")
        mintosec = min * 60
        totalTime = mintosec + sec 
        Score = ((1 / totalTime) * 1000) + brickCount
        Score = int(Score)
        display.fill(black)
        win = pauseFont.render("You Won!", False, white)
        exit = myfont.render("Press [C] to exit the game.", False, white)
        Surface31 = myfont.render("Your Score is: " + str(Score), False, white)
        display.blit(win, (235, 100))
        display.blit(exit, (205, 175))
        display.blit(Surface23, (160, 200))
        display.blit(Surface31, (235, 300))
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit
            if event.type == pygame.KEYDOWN:
                if initCount < 3:
                        initials += dic[event.key]
                        Surface30 = myfont.render(initials, False, white)
                        display.blit(Surface23, (700, 200))
                        initCount += 1
                if event.key == pygame.K_c:
                    pygame.quit()
                    sys.exit
        if initCount == 3:
            leaderboards.write(initials + ": " + str(Score) + '\n')
            initCount += 1
        if initCount == 4:
            leaderboards.close()
                
#time code
    milsec += 1
    if milsec == 60:
        sec += 1
        milsec = 0
    elif sec < 10:
        time = str(min) + ":0" + str(sec)
    elif sec >= 10 and sec < 59:
        time = str(min) + ":" + str(sec)
    elif sec == 60:
        min += 1
        sec = 0
        time = str(min) + ":0" + str(sec)    

    paddle1 = (Paddle(px, (winHeight * 0.8)))
    paddle2 = (Paddle(dx, (winHeight * 0.1)))
    padImg = Paddle.getPad(Paddle(paddle1.padx, paddle1.pady))
    paddle2rect = padImg.get_rect()
    padrect = padImg.get_rect()
    padrect.x = Paddle.getPadx(Paddle(paddle1.padx, paddle1.pady))
    padrect.y = Paddle.getPady(Paddle(paddle1.padx, paddle1.pady))
    paddle2rect.x = Paddle.getPadx(Paddle(paddle2.padx, paddle2.pady))
    paddle2rect.y = Paddle.getPady(Paddle(paddle2.padx, paddle2.pady))
    Rectx = []
    Recty = []
    def BRectsxy(a, b, c, d, e):
        for i in range(0, 21):
            if i < 10:
                a[i].x = b[i].x
                a[i].y = b[i].y
                d.append(a[i].x)
                e.append(a[i].y)
            else:
                a[i].x = c[i-10].x
                a[i].y = c[i-10].y
                d.append(a[i].x)
                e.append(a[i].y)
        return d, e
    BRectsxy(BRects, Bricks1, Bricks2, Rectx, Recty)

   
#Main button events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_p:
                pause = True

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                x_change = -7
                
            elif event.key == pygame.K_RIGHT:
                x_change = 7
                
        elif event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                x_change = 0



#keeps paddle on screen
    if padrect.left < 0: 
        x_change = 0
        px = px + 1
    elif padrect.right > winWidth:
        x_change = 0
        px = px -1
#keeps paddle2 on screen
    if paddle2rect.left < 0: 
        x2_change = 7
    elif paddle2rect.right > winWidth:
        x2_change = -7
#changes direction of ball when hitting paddle
    if ballrect.x >= px and ballrect.x <= px + 15 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[1] 
        speed[0] = speed2[0]
    if ballrect.x > px + 15 and ballrect.x <= px + 29 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[3] 
        speed[0] = speed2[2]
    if ballrect.x > px + 29 and ballrect.x <= px + 43 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[5] 
        speed[0] = speed2[4]
    if ballrect.x > px + 43and ballrect.x <= px + 57 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[7] 
        speed[0] = speed2[6]
    if ballrect.x > px + 57 and ballrect.x <= px + 71 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[5] 
        speed[0] = -speed2[4]
    if ballrect.x > px + 71 and ballrect.x <= px + 85 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[3] 
        speed[0] = -speed2[2]
    if ballrect.x > px + 85 and ballrect.x <= px + 100 and ballrect.y >= 385 and ballrect.y <= 387:
        speed[1] =  speed2[1] 
        speed[0] = -speed2[0]

#moves ball    
    ballrect = ballrect.move(speed)

#moves paddle 2
    paddle2rect = paddle2rect.move(speed3)
    
#makes ball change direction when hitting borders 
    
    if ballrect.left < 0 or ballrect.right > winWidth:
        speed[0] = -speed[0]
    if ballrect.top < 0:
        breakOut = True
#lose lives when you hit bottom
    if ballrect.bottom > winHeight:
        lives = int(lives)
        ballrect.x = random
        ballrect.y = 150
        lives -= 1
        loselife = True
        if lives == 0:
            gameover = True
#gameover screen
    
    
    while gameover == True:
        leaderboards = open("Leader.txt", "a")
        lvlCounter = int(lvlCounter)
        Surface20 = pauseFont.render("Gameover", False, white)
        Surface21 = myfont.render("Press [C] to exit the game.", False, white)
        
        display.blit(Surface20, (175, 100))
        display.blit(Surface21, (175, 175))
        
        pygame.display.update()

        mintosec = min * 60
        penalty = (5 - (lvlCounter - 1)) * 120
        totalTime = mintosec + sec + penalty
        Score = ((1 / totalTime) * 10000) + brickCount
        Score = int(Score)
        
        Surface31 = myfont.render("Your Score is: " + str(Score), False, white)
        
        if lvlCounter < 2:
            Score = 0
            
        display.blit(Surface31, (235, 300))
        if Score > 0:
            display.blit(Surface23, (160, 200))
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit
            if event.type == pygame.KEYDOWN:
                if Score > 0:
                    if initCount < 3:
                        initials += dic[event.key]
                        Surface22 = myfont.render(initials, False, white)
                        display.blit(Surface22, (700, 200))
                        initCount += 1
                if event.key == pygame.K_c:
                    pygame.quit()
                    sys.exit()
        if initCount == 3:
            leaderboards.write(initials + ": " + str(Score) + '\n')
            initCount += 1
            
        if initCount == 4:
            leaderboards.close()

    

#lose life screen
    while loselife == True:
        lives = str(lives)
        Surface10 = pauseFont.render(lives +" lives left", False, white)
        Surface11 = myfont.render("Press [C] to continue the game.", False, white)
        Surface12 = myfont.render("Press [Q] to quit the game.", False, white)
        display.blit(Surface10, (275, 100))
        display.blit(Surface11, (175, 175))
        display.blit(Surface12, (200, 225))
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_c:
                    loselife = False
                elif event.key == pygame.K_q:
                    pygame.quit()
                    sys.exit()
 #paddle movement   
    px += x_change
    dx += x2_change
    display.fill(black)
    Paddle.make_paddle(Paddle((paddle1.padx), paddle1.pady))
    Ball.make_ball(Ball(ballrect.x, ballrect.y))
    Paddle.make_paddle(Paddle((paddle2.padx), paddle2.pady))
#Displays time
    Surface = myFont.render(time, False, white)
    display.blit(Surface, (720, 450))

    
#Collision between bricks and ball    
    for i in range(0, 10):
        if ballrect.colliderect(BRects[i]):
            hits[i] += 1
            speed[1] = -speed[1]
            colorCount += 1
            BrickImg = colors[colorCount]
            if colorCount == 4:
                colorCount = 0
            if hits[i] == hitCounter:
                Bricks1[i] = Brick(10000,10000)
                brickCount += 1
            break
    for i in range(10, 21):
        if ballrect.colliderect(BRects[i]):
            hits[i] += 1
            speed[1] = -speed[1]
            colorCount += 1
            BrickImg = colors[colorCount]
            if colorCount == 4:
                colorCount = 0
            if hits[i] == hitCounter:
                Bricks2[i - 10] = Brick(10000,10000)
                brickCount += 1
            break
#collision between ball and paddle2
    if ballrect.colliderect(paddle2rect):
        speed[1] = -speed[1]
#displays bricks
    def disup(x,y):
        for i in range(0, 21):
            Brick(x[i], y[i])
        return Brick(x[i], y[i])
    disup(Rectx, Recty)

#when you breakout
    while breakOut == True:
        surfWin = pauseFont.render("You Broke Out!", False, black)
        Surface5 = myfont.render("Press [Q] to quit the game.", False, black)
        Surface6 = myfont.render("Press [Space] to continue.", False, black)
        display.fill(white)
        display.blit(surfWin, (145, 100))
        display.blit(Surface5, (200, 175))
        display.blit(Surface6, (200, 225))
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    lvlCounter = int(lvlCounter)
                    lvlCounter += 1
                    lvl = True
                    breakOut = False
                    ballrect.y = 150
                    ballrect.x = random
                    speed[1] = -speed[1]

                elif event.key == pygame.K_q:
                    pygame.quit()
                    sys.exit()
#pause screen
    while pause == True:   
        Surface2 = pauseFont.render("Paused", False, white)
        Surface3 = myfont.render("Press [P] to unpause the game.", False, white)
        Surface4 = myfont.render("Press [Q] to quit the game.", False, white)
        display.blit(Surface2, (275, 100))
        display.blit(Surface3, (175, 175))
        display.blit(Surface4, (200, 225))
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_p:
                    pause = False
                elif event.key == pygame.K_q:
                    pygame.quit()
                    sys.exit()
    pygame.display.update()
    clock.tick(60)
    pygame.display.flip()

