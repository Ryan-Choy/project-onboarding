/**
 * The additive persistence of an integer, n, is the number of times you have to replace n with the sum of its digits until n becomes a single digit integer. 

The multiplicative persistence of an integer, n, is the number of times you have to replace n with the product of its digits until n becomes a single digit integer. 

Create two functions that take an integer as an argument and: 

Return its additive persistence. 
Return its multiplicative persistence. 
Examples: Additive Persistence 
additivePersistence(1679583) --> 3 
// 1 + 6 + 7 + 9 + 5 + 8 + 3 = 39 
// 3 + 9 = 12 
// 1 + 2 = 3 
// It takes 3 iterations to reach a single-digit number. 

additivePersistence(123456) --> 2 
// 1 + 2 + 3 + 4 + 5 + 6 = 21 
// 2 + 1 = 3 

additivePersistence(6) --> 0 
// Because 6 is already a single-digit integer. 
Examples: Multiplicative Persistence 
multiplicativePersistence(77) --> 4 
// 7 x 7 = 49 
// 4 x 9 = 36 
// 3 x 6 = 18 
// 1 x 8 = 8 
// It takes 4 iterations to reach a single-digit number. 

multiplicativePersistence(123456) --> 2 
// 1 x 2 x 3 x 4 x 5 x 6 = 720 
// 7 x 2 x 0 = 0 

multiplicativePersistence(4) --> 0 
// Because 4 is already a single-digit integer. 
Notes 
The input n is never negative. 
 */
var inputPersistence = 77;
function additivePersistence(input) {
	let additiveCount = 0;
	let sum = 0;
	let addInput = input.toString();
	if (input < 10) {
		return "The additive persistence is 0 because " + input + " is already a single digit number.";
	} else {
		while (addInput.toString().length != 1) {

			for (var i = 0; i < addInput.length; i += 1) {
				sum += Number(addInput.charAt(i));

			}
			addInput = sum.toString();
			additiveCount++;
			sum = 0;
		}
		return "The additive persistence of " + input + " is " + additiveCount;
	}

}

function multiplicativePersistence(input) {
	let multiplicativeCount = 0;
	let product = 1;
	let multInput = input.toString();

	if (input < 10) {
		return "The multiplicative persistence is 0 because " + input + " is already a single digit number.";
	} else {
		while (multInput.toString().length != 1) {
			for (var i = 0; i < multInput.length; i += 1) {
				product *= Number(multInput.charAt(i));
			}
			multInput = product.toString();
			multiplicativeCount++;
			product = 1;
		}
		return "The multiplicative persistence of " + input + " is " + multiplicativeCount;
	}
}

console.log(additivePersistence(inputPersistence));
console.log(multiplicativePersistence(inputPersistence));


