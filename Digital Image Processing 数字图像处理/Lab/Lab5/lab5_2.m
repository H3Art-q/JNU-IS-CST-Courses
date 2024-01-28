clc;
clear;

% Read the image
img = imread('lab5_images/lib.jpg');

% Convert to grayscale
GIMG = rgb2gray(img);

% Using four different types of Laplacian masks
laplacian1 = [0 1 0; 1 -4 1; 0 1 0];
laplacian2 = [1 1 1; 1 -8 1; 1 1 1]; 
laplacian3 = [0 -1 0; -1 4 -1; 0 -1 0];
laplacian4 = [-1 -1 -1; -1 8 -1; -1 -1 -1];

laplacianImages = cell(1,4);
for i = 1:4
    laplacianImages{i} = imfilter(GIMG, eval(['laplacian', num2str(i)]));
    figure, imshow(laplacianImages{i}), title(['Laplacian Image ', num2str(i)]);
end

% Add the Laplacian images to the original grayscale image and compare
addedImages = cell(1,4);
for i = 1:4
    addedImages{i} = imadd(GIMG, uint8(laplacianImages{i}));
    figure, imshow(addedImages{i}), title(['Image with Laplacian mask', num2str(i)]);
end

% Use Roberts and Sobel operators to obtain the gradient images
roberts = edge(GIMG, 'roberts');
sobel = edge(GIMG, 'sobel');

figure, imshow(roberts), title('Roberts Operator');
figure, imshow(sobel), title('Sobel Operator');

% Design and apply a custom sharpening mask
customSharpenMask = [-1 -1 -1; -1 9 -1; -1 -1 -1];
customSharpenedImg = imfilter(GIMG, customSharpenMask);
figure, imshow(customSharpenedImg), title('Custom Sharpened Image');