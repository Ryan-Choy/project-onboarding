/**
Write a function that returns the longest non-repeating substring for a string input. 

Examples 
longestNonrepeatingSubstring("abcabcbb") --> "abc" 

longestNonrepeatingSubstring("aaaaaa") --> "a" 

longestNonrepeatingSubstring("abcde") --> "abcde" 

longestNonrepeatingSubstring("abcda") --> "abcd" 

 */
 
function LongNonRepeat(input){
	let StringInput = input.toString();
	let currentString = [];
	let longestLength = 0;
	
	for(let i = 0; i < StringInput.length;i++){
		const currentPosition = currentString.indexOf(StringInput[i]);
		if(currentPosition !== -1){
			currentString.splice(0,currentPosition+1);
		}
		currentString.push(StringInput[i]);
		
		longestLength = Math.max(longestLength,currentString.length);
	}
	return currentString.join('');
}

console.log(LongNonRepeat("abcabcabc"));
console.log(LongNonRepeat("aaaaaa"));
console.log(LongNonRepeat("abcde"));
console.log(LongNonRepeat("abcda"));