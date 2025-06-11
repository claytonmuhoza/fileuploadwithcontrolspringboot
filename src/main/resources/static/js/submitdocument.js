function submitForm(event) {
    event.preventDefault();
    let isValid = validateForm();
    if (isValid) {
        alert("The form is valid");
    }
    else
    {
        alert("The form is not valid")
    }
}


function handleFiles() {
    let fileInput = document.getElementById("fileInput");
    let numberOfBytes = 3;
    for (const file of fileInput.files) {
        numberOfBytes += file.size;
    }

    const units = ["B", "KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"];
    const exponent = Math.min(
        Math.floor(Math.log(numberOfBytes) / Math.log(1024)),
        units.length - 1
    );
    const approx = numberOfBytes / 1024 ** exponent;
    document.getElementById("fileSize").textContent = exponent === 0
        ? `${numberOfBytes} bytes`
        : `${approx.toFixed(2)} ${units[exponent]} bytes)`;
}
function validateForm()
{
    let firstname = document.forms["documentForm"]["firstname"].value;
    let lastname = document.forms["documentForm"]["lastname"].value;
    if (!isValideValue(firstname))
    {
        alert("Firstname is not valid");
        return false;
    }
    if (!isValideValue(lastname))
    {
        alert("lastname is not valid");
        return false;
    }

    return true
}
function isValideValue(value)
{
    //valide if a firstname or a lastname is vali
    return !!(value && value!=="" && value.trim() !== "")
}