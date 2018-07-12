import sys
import platform

#Get version
f=open("C:\\Users\\natha\\Documents\\Java\\NathanIndustries\\src\\main\\java\\com\\nathan\\nathanmod\\NathanMod.java", "r")
if f.mode == 'r':
	contents=f.read()

text = contents.split(";")

for i in range(0, len(text)):
	if text[i].find("VERSION =") != -1:
		lineNumber = i

text2 = text[lineNumber].split('"')

version = text2[1]

print("Mod version = " + version)

#Generate build file
if platform.system() == "Windows":
    print("Generating build file for Windows")
    buildfile=open("buildscript.bat", "w+")
    buildfile.write("call del .\\build\\libs\\* /Q\n")
    buildfile.write("call gradlew -Pversion=" + version + " build\n")
elif platform.system() == "Linux":
	print("Generating build file for Linux")
	buildfile=open("buildscript.sh", "w+")
	buildfile.write("rm -rf ./build/libs/* \n")
	buildfile.write("gradlew -Pversion=" + version + " build\n")