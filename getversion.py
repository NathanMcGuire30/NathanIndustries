
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

print("version = " + version)

#generate build script
buildfile=open("buildscript.bat", "w+")
buildfile.write("call del C:\\Users\\natha\\Documents\\Java\\NathanIndustries\\build\\libs\\* /Q\n")
buildfile.write("call gradlew -Pversion=" + version + " build\n")
buildfile.write("call C:\\Users\\natha\\Documents\\Scripts\\CopyBuildFilesNathanIndustries.bat\n")