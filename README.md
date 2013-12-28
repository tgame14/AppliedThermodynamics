Applied Thermodynamics
==================
This is the Current Website (and github) for the Upcoming mod, Applied Thermodynamics.

Currently the mod is IN OPEN BETA!

Quick notice, Issue reports either go on the issue tracker here on github, Or Directly to me by
talking to me on #AppliedEnergistics @ irc.esper.net

Modpacks: Read the license. But in short, you need my written permission for any kind of modpacks
other than private ones (Where they are only distributed between a closed and small Community) that ofcourse it ok.

The one Exception for private modpacks is if you use AsieLauncher. Anyone using that on your server. You need to ask
For my permission. Doing otherwise will mean you are breaking the license.


Downloads!
==================
https://github.com/tgame14/AppliedThermodynamics/releases

For the Latest Dev Builds (thanks themattabase!) :
(click the button)
[![Build Status](http://themattabase.com:9090/buildStatus/icon?job=Applied Thermodynamics)](http://themattabase.com:9090/job/Applied%20Thermodynamics/)

USE WITH CARE. I AM NOT RESPONSIBLE FOR ANY KIND OF DAMAGE DONE.

Explanation
==================
AT (Applied Thermodynamics) is a mod that adds Heat to ME Networks, the bigger and more power hungry the network is, the faster it heats up,
the hotter the network gets, more and more bad effects happen, from particles and sounds to the Melting of your network into Liquid ME.

there is LOTS more Coming, Not only Heat! Check out the [wiki](https://github.com/tgame14/AppliedThermodynamics/wiki) for more information

More and More. (I am Taking Suggestions freely, as far as its a Solid suggestion and logical i may add it)

As for suggestions and comments about my code and more ideas, visit #AppliedEnergistics @ irc.esper.net which is where
i usually am when i work on AT.

My hope for release is 1.7 for AE2. no promises at all (non Dev Release - Right now its open beta, See downloads above).


License
=========
THIS MOD IS OPEN-SOURCE, YOU MAY USE SMALL SAMPLES OF IT FOR LEARNING PURPOSES AND PRIVATE PROJECTS.
IN ALL CASES THIS WEBPAGE MUST BE LINKED AS THE SOURCE AND CREDIT MUST BE GIVEN PROPERLY.
THE DISTRIBUTION OF THIS MOD BY ANYONE OTHER THAN THE CREATOR IS STRICTLY FORBIDDEN.
COMPILING THIS MOD IS ALLOWED FOR PERSONAL USE ONLY.

USE THE MOD WITH SPECIAL CARE. I AM NOT RESPONSIBLE FOR ANY SORT OR KIND OF DAMAGE DONE TO YOU,
YOUR PROPERTY OR ANY OTHER EXTENSION OF YOURSELF. THIS MOD IS SUPPLIED 'AS IS'. NO GUARRANTIES.

IN THE CASE OF MODPACKS:
ADDING THIS MOD TO YOUR MODPACK IS STRICTLY PROHIBITED WITHOUT WRITTEN PERMISSION FROM THE CREATOR.
IN ORDER TO AQUIRE PERMISSION CONTACT WITH A REQUEST: tgameBusiness@gmail.com
RECEIVING PERMISSION THROUGH ASKING TGAME14 DIRECTLY on irc.esper.net #AppliedEnergistics IS ALSO VIABLE.

IN THE CASE OF AQUIRING PERMISSION, YOU MUST CREDIT WITH A LINK TO THIS WEBPAGE.

a few words about the license:

I can not enforce anyone to follow this license. i do not have any sort of legal power Over you in that regard.
if you do not follow the license, i will not come down to hunt you. i will though in the case of public modpacks,
Expect for atleast that. the license is here because I expect the user of this mod to respect my mod and
follow my rules, which simply imply i have rights over my own work and i may do with it as i wish.

Notice
=========
I Seem to be Flamed a lot about this mod, so i want to clarify something.

AT (Applied Thermodynamics) is a Mod that Adds a new Balancing point to AE (Applied Energistics).
This new balancing point Is meant to Be challanging to the player. it is how I think Hardcore AE should be like.
If you dont like the idea and the implementation, I understand you completely. But Do not show disrespect of 
the way i feel and want this mod to be. Dont like it - Dont Play it. But Never just go off Judging it with no
real facts to back you up. Also dont judge the mod until i announce a version where it is out of Dev. the mod is
incomplete and Thus not even nearing a fully game Experience, if you dont understand that. Do not Expect me to
show much respect to you and whatever you are Flaming about. Otherwise if you Feel like some things could Be Added
Or changed for a better Experience i urge you to tell me, Another thing is that EVERYTHING is Configurable.
EVEN HEAT ITSELF! you can turn off heat and only enjoy the non heat related features i supply. That ofcourse
will mean you miss the point of the mod, But if you want that possibility, its there.
If i missed Something to be configurable. Let me know.

I try to Be as understanding and Explanatory as possible. Show me the respect of being the same way.

Compiling
=========
First of all, you dont need to compile it yourself, the jenkins link above is always synced to latest Github Commit!
Look for the big Downloads line above.

Yet if you are still interested in building manually..

1) Clone this github page to a directory.

2) open a cmd line at the folder and run 'gradlew.bat setupCIWorkspace'.

3) now open up build.gradle, and Remove line 13 (env = System.getenv()).

4) also, in build.gradle uncomment lines 68-83 (All of the increment task and the last lines).

5) replace line 32 with:

'version = config.mod_version + "." + config.build_number'.

6) now return to the cmd line and run 'gradlew.bat build'.

7) Done, Look inside the build/libs for it (The version in both the source and mcmod.info will be the same).

NOTE:
Every time you build the build number will increment, So keep that in mind.
Also a deobf version will also be built and put in build/libs Which ofcourse can be used for Dev environments.

Keep in mind, Setting this up this way will not Allow you to edit the code, for that:

1) when you first clone the project, open a cmd line there and run 'gradlew.bat setupDecompWorkspace eclipse'.

2) Point your setup as Usual. and you should have it all done.

3) dont forget to Edit the build script if you want to still export the mod correctly.

DONE! this is Everything you need to know with compiling, Its done this way since the buildscript
in github is meant for a jenkins Server and not personal use. for personal use i do the edits i stated
above.

I DO NOT SUPPORT SELF COMPILED BUILDS OR UNOFFICIAL BUILDS. if you want my support, Use the builds i supply
either through jenkins or through the releases supplied Above.



Thank You!
=========
This mod would have been far harder without the help of a few Notable resources,

The Channel #AppliedEnergistics @ irc.esper.net For Great Ideas and help with technical issues Especially :
raydeejay
AlgorithmX2
thatsIch
M3gaFr3ak
Blarghedy

theMattaBase For Setting up a jenkins for me, Thanks a lot!.

AbrarSyed for Helping me a whole Lot with configuring forge gradle.

Pahimar for making his build script open source for me to learn parts :)

Vswe For his tutorials about Modding, The best ones i have seen so far.

And Mostly, Thanks to you, the player, i hope you enjoy this as much as i did Making it.
