function submitKeyCounts() {
    var keys = $(".key-counts").val();
    var splitKeys = keys.split("\n");
    var counts = {};
    for (var key in splitKeys) {
        var data = splitKeys[key].split(",");
        if (counts[data[0]] === undefined) {
            counts[data[0]] = parseInt(data[1]);
        }
        else {
            counts[data[0]] += parseInt(data[1]);
        }
    }
    var results = "";
    for (var name in counts) {
        results += "The total for " + name + " is " + counts[name] + ".  ";
    }

    /* Would probably use knockout.js bindings or a similar framework
       here if we were going to extend this into a real application */
    $(".key-counts-results-text").text(results);
    $(".key-counts-results").show();
}

function submitPalindrome() {
    var input = $(".palindrome").val();
    var palindrome = false;

    // Assuming the empty string is not considered a palindrome
    if (input != "") {
        // We're ignoring all non-alphanumeric characters
        input = input.replace(/\W/g, '');

        // If the input equals its reverse, it is a palindrome
        var reverse = input.split("").reverse().join("");

        palindrome = input.toUpperCase() === reverse.toUpperCase();
    }

    var results = "This string " + (palindrome ? "IS" : "IS NOT") + " a palindrome.";
    $(".palindrome-results-text").text(results);
    $(".palindrome-results").show();
}



function resetKeyCounts() {
    $(".key-counts").val("John,2\nJane,3\nJohn,4\nJane,5");
    $(".key-counts-results").hide();
}

function resetPalindrome() {
    $(".palindrome").val("");
    $(".palindrome-results").hide();
}