// signature.js 파일
let canvas = document.getElementById('signature-pad');
let context = canvas.getContext('2d');

let drawing = false;
let lastX = 0;
let lastY = 0;

canvas.addEventListener('mousedown', startDrawing);
canvas.addEventListener('mousemove', draw);
canvas.addEventListener('mouseup', stopDrawing);
canvas.addEventListener('mouseout', stopDrawing);

function startDrawing(e) {
    drawing = true;
    lastX = e.offsetX;
    lastY = e.offsetY;
}

function draw(e) {
    if (!drawing) return;
    context.beginPath();
    context.moveTo(lastX, lastY);
    context.lineTo(e.offsetX, e.offsetY);
    context.stroke();
    lastX = e.offsetX;
    lastY = e.offsetY;
}

function stopDrawing() {
    drawing = false;
}

function saveSignature() {
    const dataUrl = canvas.toDataURL(); // 서명을 이미지로 변환
    console.log(dataUrl); // 데이터 URL을 콘솔에 출력하거나 서버로 전송
}
