let displayValue = "";

function appendToDisplay(value) {
    displayValue += value;
    document.getElementById('display').value = displayValue;
}

function clearDisplay() {
    displayValue = "";
    document.getElementById('display').value = displayValue;
}

function clearLastEntry() {
    displayValue = displayValue.slice(0, -1);
    document.getElementById('display').value = displayValue;
}

function calculate() {
    try {
        displayValue = eval(displayValue);
        document.getElementById('display').value = displayValue;
    } catch (error) {
        displayValue = "Error";
        document.getElementById('display').value = displayValue;
    }
}

function calculatePercentage() {
    displayValue = String(eval(displayValue) / 100);
    document.getElementById('display').value = displayValue;
}

function calculateSquareRoot() {
    displayValue = String(Math.sqrt(eval(displayValue)));
    document.getElementById('display').value = displayValue;
}

function calculateLog() {
    try {
        displayValue = String(Math.log10(eval(displayValue)));
        document.getElementById('display').value = displayValue;
    } catch (error) {
        displayValue = "Error";
        document.getElementById('display').value = displayValue;
    }
}

function calculateAntilog() {
    try {
        displayValue = String(Math.pow(10, eval(displayValue)));
        document.getElementById('display').value = displayValue;
    } catch (error) {
        displayValue = "Error";
        document.getElementById('display').value = displayValue;
    }
}





function calculateSquare() {
    try {
        displayValue = String(Math.pow(eval(displayValue), 2));
        document.getElementById('display').value = displayValue;
    } catch (error) {
        displayValue = "Error";
        document.getElementById('display').value = displayValue;
    }
}

function calculateCube() {
    try {
        displayValue = String(Math.pow(eval(displayValue), 3));
        document.getElementById('display').value = displayValue;
    } catch (error) {
        displayValue = "Error";
        document.getElementById('display').value = displayValue;
    }
}
