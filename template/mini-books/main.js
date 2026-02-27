import { jsPDF } from "./jspdf/jspdf.js";
import "./jspdf/modules/addimage.js";
import "./jspdf/modules/png_support.js";
import "./jspdf/modules/jpeg_support.js";

function getImgFromIndex(imgList,index) {
  let total = imgList[0].count;
  for (let i = 0; i < imgList.length; i++) {
    if (index < total) {
      return imgList[i].name;
    }
    else {
      total += imgList[i+1].count;
    }
  }
}

function getTotalImagesCount(imageCount) {
  let totalImagesCount = 0;
  for (let i = 0; i < imageCount; i++) {
    totalImagesCount += Number(document.getElementById(`input-${i}`).value);
  }
  return totalImagesCount;
}

function generatePDF() {

  let imageCount = document.getElementById("file-list").children.length;
  let totalImagesCount = getTotalImagesCount(imageCount);
  
  let imgList = [];
  for (let i = 0; i < imageCount; i++) {
    imgList.push({name: `img-${i}`, count: Number(document.getElementById(`input-${i}`).value)});
  }

  let pageWidth;
  let pageHeight;
  if (document.getElementById("size-select").value == "8.5x11") {
    pageWidth = 8.5;
    pageHeight = 11;
  } else {
    pageWidth = 8.27;
    pageHeight = 11.69;
  }

  const doc = new jsPDF({
    orientation: "portrait",
    unit: "in",
    format: [pageWidth, pageHeight]
  });
  
  let imgWidth = 42/32;
  let imgHeight = 26/32;
  let padding = 0.25;
  let totalWidth = imgWidth + padding;
  let totalHeight = imgHeight + padding;

  let rowLength = Math.floor(pageWidth/totalWidth);
  let colLength = Math.floor(pageHeight/totalHeight);

  for (let i = 0; i < totalImagesCount; i++) {
    let currentRow = (i % rowLength);
    let currentColumn = Math.floor(i / rowLength) % colLength;
    let l = currentRow*totalWidth;
    let h = currentColumn*totalHeight
    doc.addImage(document.getElementById(getImgFromIndex(imgList,i)),"PNG",l,h,imgWidth,imgHeight,getImgFromIndex(imgList,i),"NONE",0);
    if (currentColumn+1 >= colLength && currentRow+1 >= rowLength && i != totalImagesCount-1) {
      doc.addPage([pageWidth, pageHeight],"portrait");
      doc.setPage(doc.internal.getNumberOfPages());
    }
  }
  
  doc.save("mini-books.pdf");
}

function removeChildren(node) {
  while (node.firstChild) {
    node.removeChild(node.lastChild);
  }
}

function setSrcFromFile(node,file) {
  var reader = new FileReader();

  reader.onload = function (e) {
    node.setAttribute('src', e.target.result);
  };

  reader.readAsDataURL(file);
}

function createImageNode(imageFile, index) {
  let d = document.createElement("div");

  let images = document.createElement("div");

  let img = document.createElement("img");
  img.width = 100;
  img.height = 63; // approx. golden ratio
  img.id = `img-${index}`
  setSrcFromFile(img,imageFile);
  images.appendChild(img);
  
  let overlayImg = document.createElement("img");
  overlayImg.width = 100;
  overlayImg.height = 63; // approx. golden ratio
  overlayImg.src = "mini-book.png";
  overlayImg.hidden = true;
  overlayImg.style = "position: absolute; left: 8px;";
  images.appendChild(overlayImg);

  d.appendChild(images);

  let p = document.createElement("p");
  p.innerHTML = imageFile.name;
  p.style = "margin: 0;"
  d.appendChild(p);

  let overlayLabel = document.createElement("label");
  overlayLabel.innerHTML = "temporary overlay: "
  d.appendChild(overlayLabel);

  let overlayCheckBox = document.createElement("input");
  overlayCheckBox.type = "checkbox";
  overlayCheckBox.onchange = (e) => {overlayImg.hidden = !e.target.checked}
  d.appendChild(overlayCheckBox);
  
  let br = document.createElement("br");
  d.appendChild(br);

  let countLabel = document.createElement("label");
  countLabel.innerHTML = "# of copies:"
  d.appendChild(countLabel);

  let input = document.createElement("input");
  input.id = `input-${index}`
  input.type = "number";
  input.value = 1;
  input.min = 1;
  d.appendChild(input);

  d.style = "margin-bottom: 50px;"

  return d;
}

function handleFileChange() {
  const files = document.getElementById("file-select").files;
  if (!files) return;

  document.getElementById("generate-button").disabled = false;
  
  const fileDiv = document.getElementById("file-list");
  
  removeChildren(fileDiv);

  for (let i = 0; i < files.length; i++) {
    fileDiv.appendChild(createImageNode(files[i],i));
  }
  
}

window.handleFileChange = handleFileChange
window.generatePDF = generatePDF