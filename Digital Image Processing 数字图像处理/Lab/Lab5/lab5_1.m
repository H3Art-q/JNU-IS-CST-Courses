clc;
clear;

% Read the image
img = imread('lab5_images/lib.jpg');

% Convert to grayscale
grayImg = rgb2gray(img);

% Display the original grayscale image
figure, imshow(grayImg), title('Original Gray Image');

% Add some noise on the grey image
GIMGNoise = imnoise(grayImg, 'gaussian');

% Display the image with Gaussian noise
figure, imshow(GIMGNoise), title('Gaussian Noise Image');

% Using averaging filter with different size of averaging mask to smooth
maskSizes = [3, 5, 7];
for i = 1:length(maskSizes)
    h = fspecial('average', maskSizes(i));
    smoothedImg = imfilter(GIMGNoise, h);
    figure, imshow(smoothedImg), 
    title(['Average Filter with Mask Size ', num2str(maskSizes(i))]);
end

% Using averaging filter with different size of mask and sigma to smooth
sigmaValues = [0.5, 1, 1.5];
for i = 1:length(maskSizes)
    for j = 1:length(sigmaValues)
        h = fspecial('gaussian', maskSizes(i), sigmaValues(j));
        smoothedImg = imfilter(GIMGNoise, h);
        figure, imshow(smoothedImg), 
        title(['Gaussian Filter with Sigma ', num2str(sigmaValues(j)), ...
        ' and Mask Size ', num2str(maskSizes(i))]);
    end
end

% Design and apply a custom smoothing mask
customSmoothMask = [1 2 1; 2 4 2; 1 2 1] / 16;
customSmoothedImg = imfilter(GIMGNoise, customSmoothMask);
figure, imshow(customSmoothedImg), title('Custom Smoothed Image');