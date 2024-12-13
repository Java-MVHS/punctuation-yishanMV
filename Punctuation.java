/* 12/11
 * Yishan Lin
 * Punctuation.java
 * 
 * Working on: utilizing built-in String Methods, loops, and if--else statements
 * to find words in a paragraph with punctuation attached to them.
 * 
 * PSEUDOCODE:
 * 
 * class header
 * 
 * main()
 * 	call searchIt
 * 
 * searchIt()
 * 	D&I string with all the paragraph to find punctuation in, 
 * 	and a string to save the return value from getPunctuationWords()
 *	call getPunctuationWords(), give in parameters of the paragraph
 * 	calls printWords() by giving in parameters of the return value of getPunctuationWords()
 * 
 * getPunctuationWords()
 * 	D&I finalStr
 * 	for the length of the paragraph
 * 		everytime there is a space, set the new substring as from after
 * 		the space to the end of the word.
 * 		if the end of the word ends in punctuation (by calling charAt() using the substring as the parameter)
 * 			add the substring word to the final string
 * 	return the final string
 * 
 * charAt()
 * 	create a substring that only contains the symbol before a specific space in the paragraph,
 * 	which indicates the end of a word, and returns the ASCII value of that symbol
 * 
 * printWords()
 * 	prints out the String in its parameters
 * 	
 * 	
*/

public class Punctuation
{
	public static void main(String[] args) //main
	{
		Punctuation pu = new Punctuation(); //new instance of the Punctuation class
		pu.searchIt(); //calls searchIt()
	}
	
	public void searchIt()	//D&I entire string and calls getPunctuationWords() to get a 
	{						//string with words followed by punctuation, then prints it out by calling printIt()
		System.out.println("\n\n\n"); //3 blank lines
		String input = new String(""); //D&I string that contains the paragraph
		String printOut = new String(""); //D&I string that will be the return value of GetPunctuationWords()
		input = new String("Blood, Sweat, and Tears by Winston Churchill " +
			"May 13, 1940 " + "Mr. Speaker: " + "On Friday evening last "
			+ "I received His Majesty’s commission to form a new "
			+ "Administration. It was the evident wish and will of Parliament and the "
			+ "nation that this should be conceived on the broadest possible basis and that it should "
			+ "include all parties, both those who supported the late Government and also the parties "
			+ "of the Opposition." + "I have completed the most important part of this task. A War Cabinet has "
			+ "been formed of five Members, representing, with the Liberal Opposition, the unity of the "
			+ "nation. The three party Leaders have agreed to serve, either in the War Cabinet or in "
			+ "high executive office. The three Fighting Services have been filled. It was necessary "
			+ "that this should be done in one single day, on account of the extreme urgency and "
			+ "rigour of events. A number of other key positions were filled yesterday, and I am submitting a further list to His Majesty tonight. I hope to complete the appointment of the "
			+ "principal Ministers during tomorrow. The appointment of the other Ministers usually "
			+ "takes a little longer, but I trust that, when Parliament meets again, this part of my task "
			+ "will be completed, and that the Administration will be complete in all respects. " 
			+ "Sir, I considered it in the public interest to suggest that the House should "
			+ "be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in "
			+ "accordance with the powers conferred upon him by the Resolution of the House. At the "
			+ "end of the proceedings today, the Adjournment of the House will be proposed until "
			+ "Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The "
			+ "business to be considered during that week will be notified to Members at the earliest "
			+ "opportunity. I now invite the House, by the Resolution which stands in my name, to "
			+ "record its approval of the steps taken and to declare its confidence in the new Government. "
			+ "Sir, to form an Administration of this scale and complexity is a serious "
			+ "undertaking in itself, but it must be remembered that we are in the preliminary stage of "
			+ "one of the greatest battles in history, that we are in action at many points in Norway and " 
			+ "in Holland, that we have to be prepared in the Mediterranean, that the air battle is " 
			+ "continuous and that many preparations have to be made here at home. In this crisis I " 
			+ "hope I may be pardoned if I do not address the House at any length today. I hope that " 
			+ "any of my friends and colleagues, or former colleagues, who are affected by the political " 
			+ "reconstruction, will make all allowances for any lack of ceremony with which it has been " 
			+ "necessary to act. I would say to the House, as I said to those who’ve joined this " 
			+ "government: \"I have nothing to offer but blood, toil, tears and sweat.\" " 
			+ "We have before us an ordeal of the most grievous kind. We have before " 
			+ "us many, many long months of struggle and of suffering. You ask, what is our policy? I " 
			+ "will say: It is to wage war, by sea, land and air, with all our might and with all the " 
			+ "strength that God can give us; to wage war against a monstrous tyranny, never " 
			+ "surpassed in the dark and lamentable catalogue of human crime. That is our policy. You " 
			+ "ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in " 
			+ "spite of all terror, victory, however long and hard the road may be; for without victory, " 
			+ "there is no survival. Let that be realised; no survival for the British Empire, no survival " 
			+ "for all that the British Empire has stood for, no survival for the urge and impulse of the "
			+ "ages, that mankind will move forward towards its goal. " 
			+ "But I take up my task with buoyancy and hope. I feel sure that our cause "
			+ "will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, "
			+ "and I say, \"Come then, let us go forward together with our united strength.\" "); //the entire paragraph to find punctuation in
		printOut = getPunctuationWords(input); //calls getPunctuationWords(), saves return value in a variable
		printWords(printOut); //calls printIt() to print out the return value of getPunctuationWords()
		System.out.println("\n\n\n");
		
	}
	
	public String getPunctuationWords(String userIn)	//saves all words in a pararaph that contain punctuation at the end in a string
	{
		String finalStr = new String("");	//D&I a string that saves all words with punctuation
		int wordStart = 0;	//the starting index of a new word
		
		for( int x = 1; x <= userIn.length()-1; x++)	//loops until the end of the paragraph
		{
			if(charAt(userIn, x) == (' '))	//checks if there is a space, indicating the end of a word
			{
				if(charAt(userIn, x-1) >= 33 && charAt(userIn, x-1) <= 47 ||	//these numbers represent all of the ASCII values of symbols
					charAt(userIn, x-1) >= 58 && charAt(userIn, x-1) <= 64 ||
					charAt(userIn, x-1) >= 91 && charAt(userIn, x-1) <= 96 ||	//calls charAt() to see if the
					charAt(userIn, x-1) >= 123 && charAt(userIn, x-1) <= 126)	//symbol before the space contains punctuation
				finalStr += userIn.substring(wordStart, x);	//adds the word that contains the punctuation to a string
				wordStart = x;	//makes the start of the new word after the space that is after the word before
			}					//to allow the punctuation to be checked for the next word
		}
		return finalStr; //returns the string with all of the words with punctuation
	}
	
	public int charAt(String str, int x) //converts a string to the ASCII value of the same symbol as a char
	{ 
		String sub = str.substring(x, x+1); //saves the symbol before a space as a substring
		return (sub.compareTo(" ")+32);	//converts the symbol to the ASCII value of the same symbol as a char and returns it
	}
	
	public void printWords(String toPrint)	//prints out a string
	{
		System.out.println(toPrint);	//prints the string out
	}
}
