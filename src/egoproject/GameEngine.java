/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.Command;
import egoproject.Hero;
import egoproject.Item;
import egoproject.Parser;
import egoproject.People;
import egoproject.Room;
import egoproject.UserInterface;

public class GameEngine {
    private Room currentRoom;
    private UserInterface gui;
    private Hero hero;
    private Parser parser = new Parser();

    public GameEngine() {
        this.createWorld();
    }

    private void busStory() {
    }

    private void createWorld() {
        this.hero = new Hero();
        People mother = new People("My mother", "img/mother.png",
                "[Mother] Bear in mind you WILL NOT leave the house unless you take my chlorophyll cookies to school. I'm also preparing you other healthy things to eat, so wait a bit. Ah!, don't forget to throw the toaster to the garbage, it nearly got me electrocuted.");
        People driver = new People("A regular bus driver", "img/driver.png",
                "[Driver] Hey laddy, put the fare and grab a seat will ya? Don't have all day to wait you know!");
        People teacher = new People("My teacher", "img/teacher.png",
                "[Teacher] Ok boys and girls, today you will return your essays. Did anybody forget? No excuses. No soldier of mine gives excuses. OK?\n[All class] YES SIR\n(yikes! I've only written the title! I'm DEAD)\n I have to find a way to distract him");
        People headmaster = new People("My headmaster", "",
                "[Headmaster] Hello my son, have a seat. Why did your teacher send you to me?\n(press TALK to initiate conversation)");
        People guard = new People("A guard", "img/guard.png",
                "[Guard] Hey, kid, don't move or I'll shoot you\n[New voice from speaker] Welcome to my tower. I have instructed my guards to kill you if you try anything. We know you, we've been studying you. Don't try to escape. You will be killed instantly\n[Me] ...");
        People madscientist = new People("A mad scientist!", "img/madscientist1.png",
                "[Mad Scientist (MSc)] What? Anybody said anything?");
        People madscientist2 = new People("HE IS FURIOUS", "img/madscientist2.png", "YOU ARE GOING TO DIE!");
        Room bedroom = new Room("This is my bedroom. It's untidy because I just woke up!", "img/bed2.png");
        Room door = new Room(
                "The door is locked.\nOh no... my older brother once again locked me inside!\nI shouldn't have 'borrowed' his chocolate last night... ",
                "img/door1.png");
        Room kitchen = new Room("My house's kitchen. I have to get out of here QUICKLY!", "img/kitchen1.png");
        Room yard = new Room("My school bus. Hope it doesn't leave without me. It's far to my school...",
                "img/schoolbus1.png");
        Room bus = new Room("In the entrance of the bus, is the coinslot. No money, no ride...", "img/coinslotbus.png");
        Room busseat = new Room("A bus seat?", "img/busseat.gif");
        Room schoolclass = new Room(
                "My class. My teacher. You can really see a bullet hole in his head! Ex-war hero, he imagines we are troopers. I really need to distract the teacher",
                "img/schoolclass1.png");
        Room headmastersoffice = new Room("The headmaster's office... I have had bad experiences in here before!",
                "img/headmastersoffice.png");
        Room dungeon = new Room(
                "Grrr... Cold... Dungeon... Why, what, how...? My legs and hands are tied with rope. I cannot move. My bag is next to me",
                "img/dungeon1.png");
        Room lab = new Room(
                "The mad scientist's lab... I must be very careful now. Have to find a way to knock him down and get to the control panel. I am above",
                "img/lab1.png");
        Room panel = new Room("I must deactivate the Control Panel", "img/panel1.png");
        bedroom.setExit("right", door);
        bedroom.setExit("left", door);
        door.setExit("forward", kitchen);
        door.setExit("left", bedroom);
        door.setExit("right", bedroom);
        kitchen.setExit("back", door);
        kitchen.setExit("forward", yard);
        kitchen.setPerson(mother);
        yard.setExit("forward", bus);
        yard.setExit("back", kitchen);
        bus.setExit("right", busseat);
        bus.setExit("forward", busseat);
        bus.setExit("back", yard);
        bus.setPerson(driver);
        busseat.setExit("forward", schoolclass);
        schoolclass.setExit("forward", headmastersoffice);
        schoolclass.setExit("back", headmastersoffice);
        schoolclass.setExit("right", headmastersoffice);
        schoolclass.setExit("left", headmastersoffice);
        schoolclass.setPerson(teacher);
        headmastersoffice.setExit("back", dungeon);
        headmastersoffice.setExit("forward", dungeon);
        headmastersoffice.setExit("right", dungeon);
        headmastersoffice.setExit("left", dungeon);
        headmastersoffice.setPerson(headmaster);
        Room corridor1 = new Room("It's so dark... I have to find an exit... Did I already pass this place?",
                "img/corridor2.png");
        Room corridor2 = new Room("It's so dark... I have to find an exit... Did I already pass this place?",
                "img/corridor2.png");
        Room corridor3 = new Room("It's so dark... I have to find an exit... Did I already pass this place?",
                "img/corridor2.png");
        Room corridor6 = new Room("It's so dark... I have to find an exit... Did I already pass this place?",
                "img/corridor2.png");
        Room corridor9 = new Room("It's so dark... I have to find an exit... Did I already pass this place?",
                "img/corridor2.png");
        Room corridor11 = new Room("An exit!", "img/corridor3.png");
        Room corridor4 = new Room("A dead end", "img/corridor1.png");
        Room corridor5 = new Room("A dead end", "img/corridor1.png");
        Room corridor7 = new Room("A dead end", "img/corridor1.png");
        Room corridor8 = new Room("A dead end", "img/corridor1.png");
        Room corridor10 = new Room("A dead end", "img/corridor1.png");
        dungeon.setExit("forward", corridor1);
        dungeon.setExit("right", corridor1);
        dungeon.setPerson(guard);
        corridor1.setExit("back", dungeon);
        corridor1.setExit("right", corridor2);
        corridor1.setExit("left", corridor3);
        corridor2.setExit("back", corridor1);
        corridor2.setExit("right", corridor4);
        corridor2.setExit("left", corridor5);
        corridor4.setExit("back", corridor2);
        corridor5.setExit("back", corridor2);
        corridor3.setExit("back", corridor1);
        corridor3.setExit("right", corridor6);
        corridor3.setExit("left", corridor7);
        corridor7.setExit("back", corridor3);
        corridor6.setExit("back", corridor3);
        corridor6.setExit("right", corridor8);
        corridor6.setExit("left", corridor9);
        corridor8.setExit("back", corridor6);
        corridor9.setExit("back", corridor7);
        corridor9.setExit("right", corridor10);
        corridor9.setExit("left", corridor11);
        corridor10.setExit("back", corridor9);
        corridor11.setExit("back", corridor9);
        corridor11.setExit("forward", lab);
        lab.setExit("forward", panel);
        lab.setExit("back", corridor11);
        lab.setPerson(madscientist);
        panel.setExit("back", lab);
        panel.setPerson(madscientist);
        this.currentRoom = bedroom;
        bedroom.setItem("bag");
        door.setItem("stop-sign");
        kitchen.setItem("egg");
        kitchen.setItem("toaster");
        kitchen.setItem("cookies");
        schoolclass.setItem("sharpener");
        dungeon.setItem("box");
        panel.setItem("chip");
        panel.setItem("gun");
        panel.setItem("plug");
    }

    private void endGame() {
        this.gui.dispose();
    }

    private void endscene() {
        this.gui.setPersonImage("");
        this.gui.setImage("img/theend.png");
        this.gui.println("You are a great player, hope you had fun!\nPress QUIT to exit the game");
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            this.gui.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = this.currentRoom.getExit(direction);
        if (nextRoom == null) {
            this.gui.println("There is no way going there!");
        } else {
            if (this.currentRoom.is("door") & direction.equals("forward") && !this.hero.shoes | this.hero.locked) {
                this.gui.println("I cannot leave yet, need the shoes and a way out of the room!");
                return;
            }
            if (this.currentRoom.is("kitchen") & direction.equals("forward") && !this.hero.kitchensafe) {
                this.gui.println("[Mother] Where do you think you're going? Sit here. EAT!");
                return;
            }
            if (this.currentRoom.is("coinslotbus") & (direction.equals("forward") | direction.equals("right"))) {
                if (!this.hero.buscoin) {
                    this.gui.println(
                            "[Driver] Hey what do ya think yer doin'? Pay up or walk, laddy\n[Me] Ok ok just a sec.\n(Oh no, I don't have any coins to put in the slot)");
                    return;
                }
                this.busStory();
                nextRoom = nextRoom.getExit("forward");
            }
            if (this.currentRoom.is("schoolclass") && this.hero.hasItem("essay")) {
                this.gui.println("Are you kidding? He WILL SHOOT ME!!!");
                return;
            }
            if (this.currentRoom.is("headmastersoffice") && !this.hero.headmasterout) {
                this.gui.println("I can't move...");
                return;
            }
            if (this.currentRoom.is("dungeon") && !this.hero.findtrap) {
                this.gui.println("Where to go? The door is locked and there must be 1000 guards outside");
                if (this.hero.tiedup) {
                    this.gui.println("Besides, I'm tied up! I can't move, remember?");
                }
                return;
            }
            if (this.currentRoom.is("lab") && !this.hero.madout & direction.equals("forward")) {
                this.gui.println("I can't go there, he will see me. Only if he was asleep or something");
                return;
            }
            if (this.currentRoom.is("panel") & this.hero.theend) {
                this.endscene();
            } else {
                this.currentRoom = nextRoom;
                this.gui.setImage(this.currentRoom.getImagePath());
                if (this.currentRoom.hasPerson()) {
                    this.gui.setPersonImage(this.currentRoom.getPersonIconPath());
                } else {
                    this.gui.setPersonImage("");
                }
                this.gui.println(this.currentRoom.getLongDescription());
            }
        }
    }

    public void interpretCommand(String commandLine) {
        commandLine = commandLine.toLowerCase();
        this.gui.println("\n'" + commandLine + "'");
        Command command = this.parser.getCommand(commandLine);
        if (command.isUnknown()) {
            this.gui.println("I don't know what you mean by that,\npress 'help' for keywords");
            return;
        }
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            this.printHelp();
        } else if (commandWord.equals("go")) {
            this.goRoom(command);
        } else if (commandWord.equals("quit")) {
            if (command.hasSecondWord()) {
                this.gui.println("Quit what?");
            } else {
                this.endGame();
            }
        } else if (commandWord.equals("look")) {
            if (!command.hasSecondWord()) {
                this.gui.println(this.currentRoom.getLongDescription());
                this.printLook();
            }
        } else if (commandWord.equals("take")) {
            if (!command.hasSecondWord()) {
                this.gui.println("I cannot take what I don't know");
            } else {
                this.takeItem(command);
            }
        } else if (commandWord.equals("use")) {
            if (!command.hasSecondWord()) {
                this.gui.println("What to use?");
            } else {
                this.useItem(command);
            }
        } else if (commandWord.equals("talk")) {
            if (!this.currentRoom.hasPerson()) {
                this.gui.println(
                        "There's no one to talk to. Unless you mean yourself.\nNot very intelligent though ;-)");
            } else {
                this.talkSequence();
            }
        }
    }

    private void introductionVideo() {
    }

    private void printHelp() {
        this.gui.println("I am inside a computer game");
        this.gui.println("Everything I do, is controlled by a higher being... Yeah right!");
        this.gui.println("User-master, if you exist, command me with:");
        this.gui.println("- go forward/back/left/right");
        this.gui.println("- look");
        this.gui.println("- take A (e.g. take pillow)");
        this.gui.println("- use A   B   (e.g use mouse/ use dog cat)");
        this.gui.println("- help");
        this.gui.println("- quit");
    }

    private void printLook() {
        String roomItems = this.currentRoom.getRoomItems();
        if (roomItems == "") {
            this.gui.println("I see nothing else in here...");
        } else {
            this.gui.println("After a few seconds eye scanning, I can see the following:");
            this.gui.println(roomItems);
        }
    }

    private void printWelcome() {
        this.gui.println(
                "I slowly get out of bed...\nI am in my bedroom.\nThe time is 07:20. I have to go to school\nI get dressed, but I can't find my shoes...\nPress 'help' for, well you know!");
        this.gui.setImage("img/bed2.png");
    }

    public void setGUI(UserInterface userInterface) {
        this.gui = userInterface;
        this.introductionVideo();
        this.printWelcome();
    }

    private void takeItem(Command command) {
        String itemName = command.getSecondWord();
        if (this.hero.hasItem(itemName)) {
            this.gui.println("I've got it already");
            return;
        }
        if (!this.currentRoom.hasItem(itemName)) {
            this.gui.println("Can't see any " + itemName + " in here");
            return;
        }
        if (itemName.equals("box")) {
            if (this.hero.tiedup) {
                this.gui.println("I can't move. My hands and feet are tied with rope.");
                return;
            }
            if (this.hero.guardclear) {
                this.gui.println(
                        "It seems to be connected to the wall. I pull the one side and a trap door opens. WOW! It's an escape door. Unreal!");
                this.hero.findtrap = true;
                this.gui.setImage("img/dungeon3.png");
                return;
            }
            this.gui.println("No way, I'm in danger. It's not safe.");
            return;
        }
        this.gui.println("I take the " + itemName);
        this.currentRoom.removeItem(itemName);
        this.hero.addItem(itemName);
        this.gui.addListItem(itemName);
        if (itemName.equals("bag")) {
            this.gui.println("Ah! my shoes were behind the bag. I'd better take them");
            this.gui.println("Inside the bag there is a book, a pen and an essay due for...\nOh-oh... TODAY!");
            Item shoes = new Item("A pair of SHOES. They're mine! both of them...", "shoes");
            Item pen = new Item("A yellow PEN, regular shape, quite solid", "pen");
            Item essay = new Item(
                    "A piece of PAPER, my semi finished assignment. Semi means that I have only written my name and title...",
                    "paper");
            Item book = new Item("A very HEAVY BOOK!!!", "book");
            this.hero.addItem("shoes");
            this.hero.addItem("pen");
            this.hero.addItem("book");
            this.hero.addItem("essay");
            this.gui.addListItem("shoes");
            this.gui.addListItem("pen");
            this.gui.addListItem("book");
            this.gui.addListItem("essay");
            this.gui.setImage("img/bed1.png");
            this.currentRoom.changeImagePath("img/bed1.png");
        }
        if (itemName.equals("stop-sign")) {
            this.gui.setImage("img/door2.png");
            this.currentRoom.changeImagePath("img/door2.png");
            this.gui.println("A stop sign is always useful!\nThere is a nail on the door");
            this.currentRoom.setItem("nail");
        }
        if (itemName.equals("nail")) {
            this.gui.setImage("img/door3.png");
            this.currentRoom.changeImagePath("img/door3.png");
        }
        if (itemName.equals("cookies")) {
            this.gui.println("Hm, I'd better take that toaster too!");
            this.currentRoom.removeItem("toaster");
            if (this.hero.hasItem("egg")) {
                this.gui.setImage("img/kitchen3.png");
                this.currentRoom.changeImagePath("img/kitchen3.png");
            } else {
                this.gui.setImage("img/kitchen5.png");
                this.currentRoom.changeImagePath("img/kitchen5.png");
            }
            this.hero.addItem("toaster");
            this.gui.addListItem("toaster");
        }
        if (itemName.equals("toaster")) {
            this.gui.println("Although I'll hate myself later, I also take the... green cookies");
            this.currentRoom.removeItem("cookies");
            if (this.hero.hasItem("egg")) {
                this.gui.setImage("img/kitchen3.png");
                this.currentRoom.changeImagePath("img/kitchen3.png");
            } else {
                this.gui.setImage("img/kitchen5.png");
                this.currentRoom.changeImagePath("img/kitchen5.png");
            }
            this.hero.addItem("cookies");
            this.gui.addListItem("cookies");
        }
        if (itemName.equals("egg")) {
            this.gui.println(
                    "'Mum, look out of the window', I shout. Fortunately, she turns and I grab the raw egg. What can I do with it, I wonder!");
            if (this.hero.hasItem("cookies")) {
                this.gui.setImage("img/kitchen3.png");
                this.currentRoom.changeImagePath("img/kitchen3.png");
            } else {
                this.gui.setImage("img/kitchen2.png");
                this.currentRoom.changeImagePath("img/kitchen2.png");
            }
        }
        if (itemName.equals("sharpener")) {
            this.gui.println(
                    "Very slowly, I try to take the pencil sharpener...\n[Teacher] What? What was that? I heard something moving!\n[Me] Gulp...\n(ok, now what?)");
            this.gui.setImage("img/schoolclass2.png");
        }
        if (itemName.equals("plug")) {
            this.gui.println("'Do not unplug'. Yeah right! That's too easy.");
            this.gui.setImage("img/panel2.png");
            this.gui.println(
                    "Oh oh, that crazy guy is starting to get out of the coma, I have to find a way to stop him!");
            this.hero.unplugged = true;
        }
        if (this.hero.unplugged & (itemName.equals("chip") | itemName.equals("gun"))) {
            this.gui.println("I take the gun and the chip, the gun is not yet loaded.");
            this.gui.removeListItem("plug");
            this.gui.setImage("img/panel3.png");
            if (itemName.equals("chip")) {
                this.hero.hasItem("gun");
                this.gui.addListItem("gun");
            } else {
                this.gui.addListItem("chip");
                this.gui.addListItem("chip");
            }
        }
    }

    private void talkSequence() {
        if (this.currentRoom.is("headmastersoffice")) {
            switch (this.hero.headmastertalk) {
                case 0: {
                    this.gui.println(this.currentRoom.getPersonTalk());
                    this.gui.println("[Me] I did nothing sir, I am innocent!");
                    this.gui.println(
                            "[Headmaster] Yes yes, that's what you said the last time. But it was you who blew the chemistry lab!");
                    this.hero.headmastertalk = 1;
                    break;
                }
                case 1: {
                    this.gui.println(
                            "[Me] It was an accident! Believe me this time I didn't do anything. I mean, I didn't do the essay, yes. But only that. Really.");
                    this.gui.println(
                            "[Headmaster] Hmm... Ok, look. We'll cut a deal. You are a clever kid. You and Johnny are the best students I've got.");
                    this.hero.headmastertalk = 2;
                    break;
                }
                case 2: {
                    this.gui.println(
                            "[Me] Johnny, sir? Sir, it's been over a month that he's been missing. And... what do you mean a deal?");
                    this.gui.println(
                            "[Headmaster] Ha! So little you know. You have no idea... It was me who told your teacher to send you to me. It was all arranged for you.");
                    this.hero.headmastertalk = 3;
                    break;
                }
                case 3: {
                    this.gui.println("[Me] I... I... I don't understand.");
                    this.gui.println("[Headmaster] You don't need to, yet. Now prepare, I'm going to hypnotize you!");
                    this.gui.setImage("img/headmasterANI.gif");
                    this.hero.headmastertalk = 4;
                    break;
                }
                case 4: {
                    this.gui.println("[Me] You? Hypnotize me? NO WAY!");
                    this.gui.println("[Headmaster] Relax, watch my eyes...");
                    this.hero.headmastertalk = 5;
                    break;
                }
                case 5: {
                    this.gui.println("[Me] I... will... not... let.... ");
                    this.gui.println("[Headmaster] But you have, you already have...");
                    this.hero.headmastertalk = 6;
                    this.hero.headmasterout = true;
                    break;
                }
                case 6: {
                    this.gui.println("[Me] No... must... get... out...");
                }
            }
        } else if (this.currentRoom.is("dungeon")) {
            switch (this.hero.guardtalk) {
                case 0: {
                    this.gui.println("[Me] Hey guard... let me go");
                    this.gui.println(
                            "[Guard] Sorry boy, I'm following doctor's orders, see? I can't let you go, I have to shoot you if you do, you see?");
                    this.hero.guardtalk = 1;
                    break;
                }
                case 1: {
                    this.gui.println(
                            "[Me] Hey guard... spare my life, don't you have kids of your own? I have a mother waiting for me at home. Let me go, I won't tell anyone. PLEASEEEEEEE");
                    this.gui.println(
                            "[Guard] Kiddo, I have 2 kids myself, see? But I must bring food, see, it's a job, nothing personal. Tell me if you need anything though?");
                    this.hero.guardtalk = 2;
                    break;
                }
                case 2: {
                    this.gui.println(
                            "[Me] Hey guard... Hi... Can you bring me something to eat? My mom started a diet with healthy foods, yuck stuff you know?");
                    this.gui.println(
                            "[Guard] Yeah, my lady started the same diet, it's yuck food every day. Well... perhaps... Hm, on second thought, No.");
                    this.hero.guardtalk = 3;
                    break;
                }
                case 3: {
                    this.gui.println("[Me] Pretty pleaseeeeeeeeeeeeeeeeeeeee");
                    this.gui.println(
                            "[Guard] Hm... Well, you're tied up for the moment, I suppose I could go and bring you a piece of pizza from the fridge. Ok I'll go now, but if I hear anything fishy, BANG, get it?");
                    this.gui.println("[Me] Eghm, ok?");
                    this.gui.setPersonImage("img/guard2.png");
                    this.hero.guardaway = true;
                    this.currentRoom.removePerson();
                }
            }
        } else if (this.currentRoom.is("lab1")) {
            switch (this.hero.madtalk1) {
                case 0: {
                    this.gui.println("[Me] Bohohoooo... ");
                    this.gui.println("(I sound very spooky inside the corridor)");
                    this.gui.println("[M.Sc] What? WHO? Who is that? Oh no, I'm having these dreams again...");
                    this.hero.madtalk1 = 1;
                    break;
                }
                case 1: {
                    this.gui.println("[Me] Noooo, I'mmm yourrr conscienceee");
                    this.gui.println("[M.Sc] Oh, hello conscience! It's a long time since I heard you, how are you?");
                    this.gui.println("(Geez this mad scientist is really wacko!)");
                    this.hero.madtalk1 = 2;
                    break;
                }
                case 2: {
                    this.gui.println("[Me] What are your plans with the boy?");
                    this.gui.println(
                            "[M.Sc] Oh, him! Well, remember when I was a kid and I told you, conscience, that I want to rule the world? Well this day has come. I'll use these boys!");
                    this.hero.madtalk1 = 3;
                    break;
                }
                case 3: {
                    this.gui.println("[Me] What do you mean? How?");
                    this.gui.println(
                            "[M.Sc] Ah, you never could understand me. I have created a device to implant chips into children. It's so safe I will implant one on myself because I don't know how to drive! Who will believe that a child is actually my agent. They are small, they can sneak anywhere. It's the beginning of the EGO project...");
                    this.hero.madtalk1 = 4;
                    break;
                }
                case 4: {
                    this.gui.println("[Me] The what? The EGO project? What's that?");
                    this.gui.println(
                            "[M.Sc] HAHAHA, the EGOMANIACS CORPORATION. Villains from all over the world and I lead them. Conscience, observe because in a few minutes, Johnny, the first kid I sent, will soon get the codes for the nuclear silo. The computer is connected directly to his brain. BUAAHAHAHAHA! The world will be in my hands...");
                    this.hero.madtalk1 = 5;
                    break;
                }
                case 5: {
                    this.gui.println("(Things are getting out of hand, I have to say something intelligent)");
                    this.gui.println("[Me] Ehm, ehm... Eh, Bad boy? (Couldn't I do better?)");
                    this.gui.println(
                            "[M.Sc] Uh? Bad... Boy... (claps) My... my mommy used to say this to me.... my mommy...(claps)");
                    this.gui.println("(He puts his hands on his eyes and starts crying)\bI have to act now!");
                    this.hero.madeyesshut = true;
                    this.hero.madtalk1 = 6;
                    break;
                }
                case 6: {
                    this.gui.println("[Me] Bad boy, you!");
                    this.gui.println("[M.Sc] OUAAAAAAAAAAAAAAAAAAAAAAAAAAAA (tears)");
                }
            }
        } else {
            this.gui.println(this.currentRoom.getPersonTalk());
        }
    }

    private void useItem(Command command) {
        String itemUse = command.getSecondWord();
        String itemUseWith = "";
        if (command.hasThirdWord()) {
            itemUseWith = command.getThirdWord();
        }
        if (!this.hero.hasItem(itemUse)) {
            this.gui.println("Cannot use it, I don't have the " + itemUse);
            return;
        }
        if (!itemUseWith.equals("") & !this.hero.hasItem(itemUseWith)) {
            this.gui.println("Cannot do that, I don't have the " + itemUseWith);
            return;
        }
        if (itemUse.equals("shoes")) {
            if (!this.hero.shoes & this.hero.hasItem("shoes")) {
                this.gui.println("I put on the shoes");
                this.hero.shoes = true;
                this.gui.removeListItem("shoes");
                this.hero.removeItem("shoes");
            } else if (this.hero.shoes) {
                this.gui.println("I already wear them!");
            } else {
                this.gui.println("Do you see any shoes around?");
            }
            return;
        }
        if (this.currentRoom.is("door") && itemUse.equals("gadget") & this.hero.hasItem("gadget") & this.hero.locked) {
            this.gui.println("P I E C E of cake! Door opened...");
            this.hero.locked = false;
            this.gui.setImage("img/door4.png");
            this.currentRoom.changeImagePath("img/door4.png");
            return;
        }
        if (itemUse.equals("pen") & itemUseWith.equals("nail") | itemUse.equals("nail") & itemUseWith.equals("pen")) {
            this.gui.println("WOW!!! I've created a GADGET to open doors!\nI'm really incredible!!!");
            this.gui.removeListItem("pen");
            this.gui.removeListItem("nail");
            this.hero.removeItem("pen");
            this.hero.removeItem("nail");
            this.gui.addListItem("gadget");
            this.hero.addItem("gadget");
            return;
        }
        if (itemUse.equals("pen") & this.currentRoom.is("door")) {
            this.gui.println("It's a good idea to use it, but the pen doesn't fit into the keyhole");
            return;
        }
        if (itemUse.equals("nail") & this.currentRoom.is("door")) {
            this.gui.println("I can't get a good grip with it... I need to try something else");
            return;
        }
        if (itemUse.equals("egg") & this.hero.hasItem("egg") & this.hero.hasItem("cookies")) {
            this.gui.removeListItem("egg");
            this.gui.setImage("img/kitchen4.png");
            this.currentRoom.changeImagePath("img/kitchen4.png");
            this.gui.setPersonImage("img/mother2.png");
            this.currentRoom.setPersonIconPath("img/mother2.png");
            this.gui.println("I quickly throw the egg on the table. My mom watches me speechless");
            this.gui.println(
                    "[Mother] 'AAAAAAAAAAAh!!!!!!!!!!\nGET O U T of the house, NOW!!!'\n(Oops, I really got mum angry this time...)\n'Bye bye mom, I've got a school bus to catch'");
            this.currentRoom.setPersonTalk("[Mother] Just GET OUT");
            this.hero.kitchensafe = true;
            return;
        }
        if (this.currentRoom.is("coinslotbus") & itemUse.equals("cookies")) {
            this.gui.println(
                    "[Me] Ehm, sir, there's somebody ticking your window\n(As he turns his head, I quickly squeeze the green cookies into the keyhole, and they fit!!! The driver turns again)\n[Driver] Yer must be dreaming laddy... Aha!, you've paid! Ok quickly to yer seat now");
            this.hero.removeItem("cookies");
            this.gui.removeListItem("cookies");
            this.hero.buscoin = true;
            return;
        }
        if (this.currentRoom.is("schoolclass") & itemUse.equals("sharpener")) {
            this.gui.println(
                    "[Teacher] WHAT EXACTLY DO YOU THINK YOU'RE DOING?\nHAND OVER THE ESSAY N O W!\n[Me] ...\n(Ok. I'm scared. I'm definitely really scared). I put the sharpener in my pocket");
            this.hero.paperrequest = true;
            return;
        }
        if (this.currentRoom.is("schoolclass") & itemUse.equals("essay")) {
            if (this.hero.hasItem("sharpener")) {
                this.hero.removeItem("essay");
                this.gui.removeListItem("essay");
                this.gui.setImage("img/schoolclass3.png");
                this.gui.println(
                        "[Teacher] Are you kidding with ME, SOLDIER? AM I A JOKE TO YOU? GO TO THE HEADMASTER'S OFFICE ON THE DOUBLE YOU HEAR? ON THE DOUBLE.");
                this.hero.paperrequest = true;
                return;
            }
            this.gui.println("No way, I haven't done anything, he'll kill me if he sees it...");
        }
        if (this.currentRoom.is("dungeon")) {
            if (itemUse.equals("sharpener") && this.hero.tiedup) {
                this.gui.println(
                        "Very slowly, I try to reach the sharpener from my pocket. I can barely hold it. I start cutting the rope. The rope has loosened up. I can now move. But the guard?");
                this.hero.tiedup = false;
                return;
            }
            if (!this.hero.tiedup && itemUse.equals("toaster")) {
                if (this.hero.guardaway) {
                    this.gui.println(
                            "I quickly run and put the handle of the door into the toaster. I plug it in and turn it on. Oops, that spark nearly killed me!");
                    this.gui.setImage("img/dungeon2.png");
                    this.gui.removeListItem("toaster");
                    this.hero.removeItem("toaster");
                    this.gui.setPersonImage("img/guard3.gif");
                    this.gui.println("[Guard] HEY KID, WHAT ARE YOU DOING IN THERE?");
                    this.gui.println("[Guard] AGGGGGGAGGGGGAGGGGAGGGGAGGGGG \n(ok, he's out!)");
                    this.hero.guardclear = true;
                    return;
                }
                this.gui.println("Good idea, but I have to find a way to distract the guard.");
                return;
            }
        }
        if (this.currentRoom.is("lab")) {
            if (this.hero.madeyesshut & itemUse.equals("book")) {
                this.gui.removeListItem("book");
                this.hero.removeItem("book");
                this.gui.setPersonImage("img/madscientist2.png");
                this.hero.madout = true;
                this.gui.println(
                        "Great! He is out for a while. I have to stop the computer, I must not let him do his evil plans!!! (from which movie that was from?)");
                return;
            }
            this.gui.println("He is watching around the lab, alert!");
        }
        if (this.currentRoom.is("panel")) {
            if (itemUse.equals("gun") | itemUse.equals("chip")) {
                this.gui.println("I load the chip in the gun");
                this.gui.removeListItem("gun");
                this.gui.removeListItem("chip");
                this.gui.addListItem("loaded-gun");
                this.hero.removeItem("chip");
                this.hero.removeItem("gun");
                this.hero.addItem("loaded-gun");
                this.gui.println("Oh no! The doctor is awake now, he is coming to get me");
                this.gui.setPersonImage("img/madscientist3.png");
                return;
            }
            if (itemUse.equals("loaded-gun")) {
                this.gui.setPersonImage("img/madscientist4.png");
                this.gui.println(
                        "[M.Sc] What do you think you are doing? I was planning to implant this chip on myself! PREPARE TO D I E, I'm coming for you...");
                this.gui.println("[Me] No way Jose! I know what to do next! (well, do you?)");
                this.hero.madchipon = true;
                return;
            }
            if (itemUse.equals("stop-sign") & this.hero.madchipon) {
                this.gui.setImage("img/panel4.png");
                this.gui.println(
                        "[M.Sc] Oh NO! ANYTHING BUT THAT! I cannot move, my brain is programmed to stop on traffic signs. I cannot move a single finger. OH MY PROJECT IT IS RUINED....");
                this.gui.println(
                        "[Me] That's for you to learn not to use little children for evil plans. I'll GO and call the police. You're going down...");
                this.gui.println("[M.Sc] Who would believe it. I was defeated by a single boy...");
                this.gui.println("[Me] Eh, not a single boy. I had help from a person outside our world ;-) ");
                this.gui.println("[M.Sc] Huh?");
                this.hero.theend = true;
                return;
            }
        }
        this.gui.println("This is not the time, nor the place to use it");
    }
}
